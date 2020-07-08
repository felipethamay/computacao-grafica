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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.RetaPM2D;
import model.Transformacoes2D;

public class TelaCisalhamento extends javax.swing.JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JPanel painel;
	private JButton jButtonAdicionar;
	private JButton jButtonDesenhar;
	private JLabel jLabelAdicionarPontos;
	private JLabel jLabelX;
	private JLabel jLabelY;
	private JLabel jLabelPontos;
	private JScrollPane jScrollPane;
	public JTable jTable1;
	private JTextField jTextFieldX;
	private JTextField jTextFieldY;

	public JLabel jLabelCisalhamento;
	public JLabel entX;
	public JLabel entY;
	public JLabel entAngulo;
	public JTextField startX;
	public JTextField startY;
	public JTextField startAngulo;
	public JRadioButton button1;
	public JRadioButton button2;
	public JRadioButton button3;
	public JRadioButton button4;
	public ButtonGroup grupo;
	public JButton ok;
	private JButton btnLimpar;

	// Construtor
	public TelaCisalhamento() {
		setTitle("Transformação - Cisalhamento");
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
		getContentPane().setLayout(null);
		jLabelPontos = new javax.swing.JLabel();
		jLabelPontos.setBounds(25, 127, 74, 15);

		jLabelPontos.setText("Pontos:");
		jScrollPane = new JScrollPane();
		jScrollPane.setBounds(25, 148, 163, 136);
		jTable1 = new JTable();

		jTable1.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "X", "Y" }) {

			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane.setViewportView(jTable1);
		jLabelAdicionarPontos = new JLabel();
		jLabelAdicionarPontos.setBounds(25, 11, 163, 15);
		jLabelAdicionarPontos.setText("Adicionar Pontos");
		jButtonAdicionar = new JButton();
		jButtonAdicionar.setBounds(25, 91, 105, 25);
		jButtonAdicionar.setText("Adicionar");
		jButtonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jLabelX = new JLabel();
		jLabelX.setBounds(25, 32, 32, 14);

		jLabelX.setText("X =");
		jTextFieldX = new JTextField();
		jTextFieldX.setBounds(55, 29, 44, 20);
		jLabelY = new JLabel();
		jLabelY.setBounds(25, 63, 32, 14);

		jLabelY.setText("Y = ");
		jTextFieldY = new JTextField();
		jTextFieldY.setBounds(55, 60, 44, 20);
		jButtonDesenhar = new JButton();
		jButtonDesenhar.setBounds(25, 290, 105, 25);
		jButtonDesenhar.setText("Desenhar");
		jButtonDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jLabelPontos);
		getContentPane().add(jScrollPane);
		getContentPane().add(jLabelAdicionarPontos);
		getContentPane().add(jButtonAdicionar);
		getContentPane().add(jLabelX);
		getContentPane().add(jTextFieldX);
		getContentPane().add(jLabelY);
		getContentPane().add(jTextFieldY);
		getContentPane().add(jButtonDesenhar);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(252, 30, 646, 506);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		painel = new TelaPainel();
		painel.setBounds(0, 0, 640, 483);
		internalFrame.getContentPane().add(painel);
		grupo = new ButtonGroup();
		entX = new JLabel("a = ");
		getContentPane().add(entX);
		entX.setSize(36, 14);
		entX.setLocation(31, 360);
		startX = new JTextField();
		getContentPane().add(startX);
		startX.setSize(36, 20);
		startX.setLocation(63, 357);
		entY = new JLabel("b = ");
		getContentPane().add(entY);
		entY.setSize(33, 14);
		entY.setLocation(34, 388);
		startY = new JTextField();
		getContentPane().add(startY);
		startY.setSize(36, 20);
		startY.setLocation(63, 388);
		button1 = new JRadioButton("Cisalhar em X");
		getContentPane().add(button1);
		grupo.add(button1);
		button1.setSelected(true);
		button1.setSize(163, 23);
		button1.setLocation(25, 412);

		jLabelCisalhamento = new JLabel("Cisalhamento");
		getContentPane().add(jLabelCisalhamento);
		jLabelCisalhamento.setSize(153, 14);
		jLabelCisalhamento.setLocation(35, 337);
		button2 = new JRadioButton("Cisalhar em Y");
		getContentPane().add(button2);
		grupo.add(button2);
		button2.setSize(163, 23);
		button2.setLocation(25, 438);
		button3 = new JRadioButton("Cisalhar em X e Y");
		getContentPane().add(button3);
		grupo.add(button3);
		button3.setSize(163, 23);
		button3.setLocation(25, 464);
		ok = new JButton("OK");
		getContentPane().add(ok);
		ok.setSize(105, 25);
		ok.setLocation(25, 494);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				modelo.setNumRows(0);
				jTextFieldX.setText("");
				jTextFieldY.setText("");
				TelaPainel.altera();
				repaint();
			}
		});
		btnLimpar.setBounds(25, 535, 105, 24);
		getContentPane().add(btnLimpar);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (grupo.getSelection() == button1.getModel()) {

					String entradaA = startX.getText();
					entradaA = entradaA.replace(',', '.');
					double a = Double.parseDouble(entradaA);

					cisalhar(a, 0);

				} else if (grupo.getSelection() == button2.getModel()) {

					String entradaB = startY.getText();
					entradaB = entradaB.replace(',', '.');
					double b = Double.parseDouble(entradaB);

					cisalhar(0, b);

				} else if (grupo.getSelection() == button3.getModel()) {

					String entradaA = startX.getText();
					entradaA = entradaA.replace(',', '.');
					double a = Double.parseDouble(entradaA);

					String entradaB = startY.getText();
					entradaB = entradaB.replace(',', '.');
					double b = Double.parseDouble(entradaB);

					cisalhar(a, b);

				}
			}
		});
		internalFrame.setVisible(true);
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 1000) / 2, (screenSize.height - 700) / 2, 940, 599);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		String entradaX = jTextFieldX.getText();
		int x = Integer.parseInt(entradaX);

		String entradaY = jTextFieldY.getText();
		int y = Integer.parseInt(entradaY);

		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

		modelo.addRow(new Object[] { x, y });

	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		desenhar();

	}

	public void desenhar() {
		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 0;
		cor[2] = 255;

		for (int i = 0; i < jTable1.getRowCount(); i++) {

			if (i == (jTable1.getRowCount() - 1)) {

				String entradax1 = "" + jTable1.getValueAt(0, 0);
				int x1 = Integer.parseInt(entradax1);

				String entraday1 = "" + jTable1.getValueAt(0, 1);
				int y1 = Integer.parseInt(entraday1);

				String entradax2 = "" + jTable1.getValueAt(i, 0);
				int x2 = Integer.parseInt(entradax2);

				String entraday2 = "" + jTable1.getValueAt(i, 1);
				int y2 = Integer.parseInt(entraday2);

				RetaPM2D.executaPM(x1, y1, x2, y2, cor);

			} else {

				String entradax1 = "" + jTable1.getValueAt(i, 0);
				int x1 = Integer.parseInt(entradax1);

				String entraday1 = "" + jTable1.getValueAt(i, 1);
				int y1 = Integer.parseInt(entraday1);

				String entradax2 = "" + jTable1.getValueAt(i + 1, 0);
				int x2 = Integer.parseInt(entradax2);

				String entraday2 = "" + jTable1.getValueAt(i + 1, 1);
				int y2 = Integer.parseInt(entraday2);

				RetaPM2D.executaPM(x1, y1, x2, y2, cor);
			}
		}

		repaint();
	}

	public void cisalhar(double a, double b) {
		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

		int[][] matrizPontos = new int[3][jTable1.getRowCount()];

		for (int i = 0; i < matrizPontos.length; i++) {

			for (int j = 0; j < matrizPontos[0].length; j++) {

				if (i == 0) {

					String entradax1 = "" + jTable1.getValueAt(j, 0);
					matrizPontos[i][j] = Integer.parseInt(entradax1);

				} else if (i == 1) {
					String entraday1 = "" + jTable1.getValueAt(j, 1);
					matrizPontos[i][j] = Integer.parseInt(entraday1);
				} else {

					matrizPontos[i][j] = 1;

				}
			}
		}

		int Tx = matrizPontos[0][0];

		int Ty = matrizPontos[1][0];

		double[][] matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.cisalhamento(a, b),
				Transformacoes2D.translacao(-Tx, -Ty));
		matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.translacao(Tx, Ty), matrizTrans);

		int[][] matrizResultante = Transformacoes2D.multiplicaMatriz(matrizTrans, matrizPontos);
		modelo.setRowCount(0);

		for (int i = 0; i < matrizResultante[0].length; i++) {
			modelo.addRow(new Object[] { matrizResultante[0][i], matrizResultante[1][i] });
		}

		TelaPainel.altera();
		desenhar();

	}

}