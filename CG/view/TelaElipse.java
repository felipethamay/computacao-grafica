package view;

/**
 * Universidade Estadual da Paraiba
 * Departamento de Computacao
 * Curso de Licenciatura Plena em Computacao
 * Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno
 * Equipe: Arthur Felipe Thamay Medeiros, Jefferson Felipe Silva de Lima, Thalles Gutembergh dos Santos
 * 2012.2 
 */

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.Elipse2D;

public class TelaElipse extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JButton jButton1 = new JButton();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel jLabel4 = new JLabel();
	private JScrollPane jScrollPane1 = new JScrollPane();
	public static JTable jTable1 = new JTable();
	private JTextField jTextField1 = new JTextField();
	private JTextField jTextField2 = new JTextField();
	public JPanel painel = new TelaPainel();
	private final JInternalFrame internalFrame = new JInternalFrame("");
	private final JButton btnLimpar = new JButton("Limpar");

	// Construtor
	public TelaElipse() {
		internalFrame.setBounds(216, 22, 648, 514);
		internalFrame.setVisible(true);
		setTitle("Elipse");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/logo.jpg")));
		initialize();
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.dispose();
	}

	/**
	 * Método principal responsável por toda execução da classe
	 */
	private void initialize() {
		getContentPane().setBackground(UIManager.getColor("windowBorder"));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		jLabel1.setBounds(24, 22, 173, 14);

		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("Elipse");
		jButton1.setBounds(44, 139, 146, 24);

		jButton1.setText("Desenhar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jLabel3.setBounds(44, 88, 61, 14);

		jLabel3.setText("Largura:");
		jLabel2.setBounds(44, 56, 48, 14);

		jLabel2.setText("Altura:");
		jLabel4.setBounds(44, 188, 55, 14);

		jLabel4.setText("Pontos:");

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "X", "Y" }) {
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setBounds(44, 222, 138, 276);
		jScrollPane1.setViewportView(jTable1);
		getContentPane().setLayout(null);
		getContentPane().add(jLabel1);
		getContentPane().add(jButton1);
		getContentPane().add(jLabel3);
		getContentPane().add(jLabel2);
		jTextField2.setBounds(117, 86, 73, 18);
		getContentPane().add(jTextField2);
		jTextField1.setBounds(117, 54, 73, 18);
		getContentPane().add(jTextField1);
		getContentPane().add(jLabel4);
		getContentPane().add(jScrollPane1);

		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		painel.setBounds(0, 0, 644, 484);
		internalFrame.getContentPane().add(painel);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				modelo.setNumRows(0);
				jTextField1.setText("");
				jTextField2.setText("");
				TelaPainel.altera();
				repaint();
			}
		});
		btnLimpar.setBounds(42, 525, 117, 24);

		getContentPane().add(btnLimpar);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 900) / 2, (screenSize.height - 600) / 2, 900, 600);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		int x = Integer.parseInt(jTextField1.getText());
		int y = Integer.parseInt(jTextField2.getText());
		Elipse2D.algorimoElipse(x, y);
		repaint();

	}

}