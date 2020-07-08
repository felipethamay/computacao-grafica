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

import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.Circunferencia2D;

public class TelaCircunferencia extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private JButton jButton_Desenha = new JButton();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel jLabel4 = new JLabel();
	private JLabel jLabel5 = new JLabel();
	private JLabel jLabel6 = new JLabel();
	private JRadioButton jRadioButton_Explicita = new JRadioButton();
	private JRadioButton jRadioButton_PontoMedio = new JRadioButton();
	private JRadioButton jRadioButton_Trigonometrico = new JRadioButton();
	private JScrollPane jScrollPane1 = new JScrollPane();
	public static JTable jTable1 = new JTable();
	private JTextField jTextField_Xcen = new JTextField();
	private JTextField jTextField_Ycen = new JTextField();
	private JTextField jTextField_raio = new JTextField();
	public JPanel tela_visao = new TelaPainel();
	public int verifica = 0;
	private final JButton btnLimpar = new JButton("Limpar");

	// Construtor
	public TelaCircunferencia() {
		setTitle("Circunferï¿½ncia");
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
		jLabel1.setBounds(31, 29, 40, 14);

		jLabel1.setText("Raio: ");
		jLabel2.setBounds(31, 81, 120, 14);

		jLabel2.setText("Coordenadas:");
		jLabel3.setBounds(31, 103, 27, 14);

		jLabel3.setText("X = ");
		jLabel4.setBounds(31, 127, 26, 14);

		jLabel4.setText("Y = ");
		jLabel5.setBounds(70, 155, 81, 14);

		jLabel5.setText("Algoritmos:");

		buttonGroup1.add(jRadioButton_PontoMedio);
		jRadioButton_PontoMedio.setBounds(46, 247, 110, 18);
		jRadioButton_PontoMedio.setText("Ponto Medio");
		jRadioButton_PontoMedio.setMargin(new Insets(0, 0, 0, 0));
		jRadioButton_PontoMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButton_PontoMedioActionPerformed(evt);
			}
		});

		buttonGroup1.add(jRadioButton_Explicita);
		jRadioButton_Explicita.setBounds(46, 181, 160, 18);
		jRadioButton_Explicita.setText("Equacao explicita");
		jRadioButton_Explicita.setMargin(new Insets(0, 0, 0, 0));
		jRadioButton_Explicita.setSelected(true);
		jRadioButton_Explicita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jRadioButton_ExplicitaActionPerformed(evt);
			}
		});

		buttonGroup1.add(jRadioButton_Trigonometrico);
		jRadioButton_Trigonometrico.setBounds(46, 214, 128, 18);
		jRadioButton_Trigonometrico.setText("Trigonometrico");
		jRadioButton_Trigonometrico.setMargin(new Insets(0, 0, 0, 0));
		jRadioButton_Trigonometrico.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButton_TrigonometricoActionPerformed(evt);
			}
		});
		jButton_Desenha.setBounds(49, 291, 115, 24);

		jButton_Desenha.setText("Desenhar");
		jButton_Desenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton_DesenhaActionPerformed(evt);
			}
		});
		jLabel6.setBounds(31, 327, 55, 14);

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
		jLabel6.setText("Pontos:");

		jTable1.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "D", "X", "Y" }) {

			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setBounds(31, 347, 186, 192);
		jScrollPane1.setViewportView(jTable1);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(241, 29, 648, 512);
		internalFrame.setVisible(true);
		getContentPane().setLayout(null);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		tela_visao.setBounds(0, 0, 704, 604);
		internalFrame.getContentPane().add(tela_visao);
		getContentPane().add(jLabel1);
		jTextField_raio.setBounds(31, 49, 83, 18);
		getContentPane().add(jTextField_raio);
		getContentPane().add(jLabel2);
		getContentPane().add(jLabel3);
		jTextField_Xcen.setBounds(70, 101, 94, 18);
		getContentPane().add(jTextField_Xcen);
		getContentPane().add(jLabel4);
		jTextField_Ycen.setBounds(69, 125, 95, 18);
		getContentPane().add(jTextField_Ycen);
		getContentPane().add(jLabel5);
		getContentPane().add(jRadioButton_Explicita);
		getContentPane().add(jRadioButton_Trigonometrico);
		getContentPane().add(jRadioButton_PontoMedio);
		getContentPane().add(jButton_Desenha);
		getContentPane().add(jLabel6);
		getContentPane().add(jScrollPane1);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				modelo.setNumRows(0);
				jTextField_raio.setText("");
				jTextField_Xcen.setText("");
				jTextField_Ycen.setText("");
				TelaPainel.altera();
				repaint();
			}
		});
		btnLimpar.setBounds(31, 557, 117, 24);

		getContentPane().add(btnLimpar);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 1000) / 2, (screenSize.height - 700) / 2, 926, 621);
	}

	private void jButton_DesenhaActionPerformed(ActionEvent evt) {

		String entrada1 = jTextField_raio.getText();
		int raio = Integer.parseInt(entrada1);

		String entrada2 = jTextField_Xcen.getText();
		if (entrada2.equals("")) {
			entrada2 = entrada2.replace("", "0");
		}
		int xcent = Integer.parseInt(entrada2);

		String entrada3 = jTextField_Ycen.getText();
		if (entrada3.equals("")) {
			entrada3 = entrada3.replace("", "0");
		}
		int ycent = Integer.parseInt(entrada3);

		if (verifica == 0) {
			Circunferencia2D.equacaoExplicitadaCircuferencia(raio, xcent, ycent);
		} else if (verifica == 1) {
			Circunferencia2D.metodoTrigonometrico(raio, xcent, ycent);
		} else {
			Circunferencia2D.pontoMedio(raio, xcent, ycent);
		}

		repaint();

	}

	private void jRadioButton_PontoMedioActionPerformed(ActionEvent evt) {
		verifica = 2;
	}

	private void jRadioButton_TrigonometricoActionPerformed(ActionEvent evt) {
		verifica = 1;
	}

	private void jRadioButton_ExplicitaActionPerformed(ActionEvent evt) {
		verifica = 0;
	}

}