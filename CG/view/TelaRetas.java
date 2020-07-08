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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.RetaDDA2D;
import model.RetaPM2D;

public class TelaRetas extends javax.swing.JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private javax.swing.JButton jButton1 = new JButton();
	private javax.swing.JComboBox jComboBox1 = new JComboBox();
	private javax.swing.JLabel jLabel1 = new JLabel();
	private javax.swing.JLabel jLabel2 = new JLabel();
	private javax.swing.JLabel jLabel3 = new JLabel();
	private javax.swing.JLabel jLabel4 = new JLabel();
	private javax.swing.JLabel jLabel5 = new JLabel();
	private javax.swing.JLabel jLabel6 = new JLabel();
	private javax.swing.JLabel jLabel7 = new JLabel();
	private javax.swing.JLabel jLabel8 = new JLabel();
	private javax.swing.JMenu jMenu2 = new JMenu();
	private javax.swing.JMenuBar jMenuBar2 = new JMenuBar();
	private javax.swing.JScrollPane jScrollPane1 = new JScrollPane();
	public static javax.swing.JTable jTable1 = new JTable();
	private javax.swing.JTextField jTextField1 = new JTextField();
	private javax.swing.JTextField jTextField2 = new JTextField();
	private javax.swing.JTextField jTextField3 = new JTextField();
	private javax.swing.JTextField jTextField4 = new JTextField();
	public JPanel painel_Visao = new TelaPainel();

	// Construtor
	public TelaRetas() {
		setTitle("Retas");
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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(UIManager.getColor("windowBorder"));

		jMenu2.setText("Menu");
		jMenuBar2.add(jMenu2);

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "D", "X", "Y" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setBounds(28, 275, 151, 259);
		jScrollPane1.setViewportView(jTable1);
		jLabel1.setBounds(28, 30, 68, 14);
		jLabel1.setText("Ponto P1:");
		jLabel4.setBounds(28, 108, 68, 14);

		jLabel4.setText("Ponto P2:");
		jLabel6.setBounds(28, 154, 26, 14);

		jLabel6.setText("Y = ");
		jLabel5.setBounds(28, 130, 27, 14);

		jLabel5.setText("X = ");
		jLabel3.setBounds(28, 76, 26, 14);

		jLabel3.setText("Y = ");
		jLabel2.setBounds(28, 52, 27, 14);

		jLabel2.setText("X = ");
		jComboBox1.setBounds(28, 196, 151, 23);

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Algoritmo DDA", "Ponto Médio" }));
		jLabel8.setBounds(28, 176, 139, 14);

		jLabel8.setText("Escolha o Algoritmo");
		jButton1.setBounds(28, 225, 151, 24);

		jButton1.setText("Desenhar");

		jButton1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String entrada1 = jTextField1.getText();
				int x1 = Integer.parseInt(entrada1);

				String entrada2 = jTextField2.getText();
				int y1 = Integer.parseInt(entrada2);

				String entrada3 = jTextField3.getText();
				int x2 = Integer.parseInt(entrada3);

				String entrada4 = jTextField4.getText();
				int y2 = Integer.parseInt(entrada4);

				int cor[] = new int[3];
				cor[0] = 0;
				cor[1] = 0;
				cor[2] = 255;

				if (jComboBox1.getSelectedIndex() == 1) {

					RetaPM2D.executaPM(x1, y1, x2, y2, cor);

				} else {

					RetaDDA2D.executaDDA(x1, y1, x2, y2, cor);

				}

				repaint();

			}
		});
		jLabel7.setBounds(28, 255, 50, 14);

		jLabel7.setText("Pontos");
		getContentPane().setLayout(null);
		getContentPane().add(jScrollPane1);
		getContentPane().add(jLabel1);
		getContentPane().add(jLabel4);
		getContentPane().add(jLabel6);
		jTextField4.setBounds(66, 152, 62, 18);
		getContentPane().add(jTextField4);
		getContentPane().add(jLabel5);
		jTextField3.setBounds(67, 128, 61, 18);
		getContentPane().add(jTextField3);
		getContentPane().add(jLabel3);
		jTextField2.setBounds(66, 74, 62, 18);
		getContentPane().add(jTextField2);
		getContentPane().add(jLabel2);
		jTextField1.setBounds(67, 50, 61, 18);
		getContentPane().add(jTextField1);
		getContentPane().add(jComboBox1);
		getContentPane().add(jLabel8);
		getContentPane().add(jButton1);
		getContentPane().add(jLabel7);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(220, 46, 648, 507);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		painel_Visao.setBounds(0, 0, 644, 484);
		internalFrame.getContentPane().add(painel_Visao);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				modelo.setNumRows(0);
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				TelaPainel.altera();
				repaint();
			}
		});
		btnLimpar.setBounds(28, 559, 89, 23);
		getContentPane().add(btnLimpar);

		internalFrame.setVisible(true);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 900) / 2, (screenSize.height - 600) / 2, 900, 621);

	}
}
