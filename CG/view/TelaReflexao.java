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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.RetaPM2D;
import model.TransformacaoDispositivo2D;
import model.Transformacoes2D;

public class TelaReflexao extends javax.swing.JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JPanel painel;
	private JButton jButtonAdicionar;
	private JButton jButtonDesenhar;
	private JLabel jLabelX;
	private JLabel jLabelY;
	private JLabel jLabelPontos;
	private JScrollPane jScrollPane1;
	public JTable jTable1;
	private JTextField jTextFieldX;
	private JTextField jTextFieldY;

	public JLabel textoTrans;
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
	public JButton aplicar;
	private JLabel labelAdicionarPontos;
	private JButton btnLimpar;

	// Construtor
	public TelaReflexao() {
		setTitle("Transformação - Reflexão");
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
		jLabelPontos = new JLabel();
		jLabelPontos.setBounds(25, 127, 80, 15);

		jLabelPontos.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelPontos.setText("Pontos:");
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(25, 148, 163, 136);
		jTable1 = new javax.swing.JTable();

		jTable1.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "X", "Y" }) {

			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane1.setViewportView(jTable1);
		jButtonAdicionar = new javax.swing.JButton();
		jButtonAdicionar.setBounds(25, 91, 105, 25);
		jButtonAdicionar.setText("Adicionar");
		jButtonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jLabelX = new JLabel();
		jLabelX.setBounds(25, 32, 30, 14);

		jLabelX.setText("X =");
		jTextFieldX = new JTextField();
		jTextFieldX.setBounds(55, 29, 51, 20);
		jLabelY = new JLabel();
		jLabelY.setBounds(25, 63, 30, 14);

		jLabelY.setText("Y = ");
		jTextFieldY = new JTextField();
		jTextFieldY.setBounds(55, 60, 51, 20);
		jButtonDesenhar = new javax.swing.JButton();
		jButtonDesenhar.setBounds(25, 290, 105, 25);

		jButtonDesenhar.setText("Desenhar");
		jButtonDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		getContentPane().add(jLabelPontos);
		getContentPane().add(jScrollPane1);
		getContentPane().add(jButtonAdicionar);
		getContentPane().add(jLabelX);
		getContentPane().add(jTextFieldX);
		getContentPane().add(jLabelY);
		getContentPane().add(jTextFieldY);
		getContentPane().add(jButtonDesenhar);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(249, 32, 645, 508);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		painel = new TelaPainel();
		painel.setBounds(0, 0, 704, 604);
		internalFrame.getContentPane().add(painel);

		labelAdicionarPontos = new JLabel();
		labelAdicionarPontos.setText("Adicionar Pontos");
		labelAdicionarPontos.setBounds(25, 11, 163, 15);
		getContentPane().add(labelAdicionarPontos);
		internalFrame.setVisible(true);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 1000) / 2, (screenSize.height - 700) / 2, 934, 601);

		textoTrans = new JLabel("Reflexão");
		textoTrans.setSize(80, 20);
		textoTrans.setLocation(35, 337);
		grupo = new ButtonGroup();
		button1 = new JRadioButton("Reflexão em X");
		button1.setSize(140, 20);
		button1.setLocation(25, 364);
		button2 = new JRadioButton("Reflexão em Y");
		button2.setSize(140, 20);
		button2.setLocation(25, 389);
		button3 = new JRadioButton("Reflexão em X e Y");
		button3.setSize(155, 20);
		button3.setLocation(25, 414);
		button4 = new JRadioButton("Reflexão numa Reta");
		button4.setSize(181, 20);
		button4.setLocation(25, 439);
		grupo.add(button1);
		grupo.add(button2);
		grupo.add(button3);
		grupo.add(button4);
		startX = new JTextField();
		startX.setSize(30, 20);
		startX.setLocation(35, 464);
		entX = new JLabel("X  + ");
		entX.setSize(36, 20);
		entX.setLocation(70, 464);
		startY = new JTextField();
		startY.setSize(30, 20);
		startY.setLocation(100, 464);

		aplicar = new JButton("OK");
		aplicar.setSize(105, 25);
		aplicar.setLocation(25, 495);
		aplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (grupo.getSelection() == button1.getModel()) {

					reflexao(1, -1);

				} else if (grupo.getSelection() == button2.getModel()) {

					reflexao(-1, 1);

				} else if (grupo.getSelection() == button3.getModel()) {

					reflexao(-1, -1);

				} else if (grupo.getSelection() == button4.getModel()) {

					String entradaA = startX.getText();
					entradaA = entradaA.replace(',', '.');
					double a = Double.parseDouble(entradaA);

					String entradaB = startY.getText();
					int b = Integer.parseInt(entradaB);

					reflexaoReta(a, b);
				}
			}

		});
		getContentPane().add(textoTrans);
		getContentPane().add(entX);
		getContentPane().add(startX);
		getContentPane().add(startY);
		getContentPane().add(button1);
		getContentPane().add(button2);
		getContentPane().add(button3);
		getContentPane().add(button4);
		getContentPane().add(aplicar);

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
		btnLimpar.setBounds(25, 537, 105, 24);
		getContentPane().add(btnLimpar);
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

	public void reflexao(int x, int y) {

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

		double[][] matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.reflexao(x, y),
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

	public void reflexaoReta(double a, int b) {

		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 0;
		cor[2] = 0;

		double cos = 1 / Math.sqrt((a * a + 1));
		double sen = a / Math.sqrt((a * a + 1));

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

		double[][] matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.rotacaonaReta(cos, -sen),
				Transformacoes2D.translacao(-Tx, -Ty));
		matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.reflexao(1, -1), matrizTrans);
		matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.rotacaonaReta(cos, sen), matrizTrans);
		matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.translacao(Tx, Ty), matrizTrans);

		int[][] matrizResultante = Transformacoes2D.multiplicaMatriz(matrizTrans, matrizPontos);

		modelo.setRowCount(0);

		for (int i = 0; i < matrizResultante[0].length; i++) {
			modelo.addRow(new Object[] { matrizResultante[0][i], matrizResultante[1][i] });
		}

		TelaPainel.altera();

		for (int i = ((-TelaPainel.x / 2) + 1); i < TelaPainel.x / 2; i++) {
			int y = (int) (a * i) + b;
			if ((y >= TelaPainel.y / 2) || (y <= -TelaPainel.y / 2)) {

			} else {
				int DCx = TransformacaoDispositivo2D.transformaPontosX(i);
				int DCy = TransformacaoDispositivo2D.transformaPontosY(y);

				TelaPainel.setPixel(DCx, DCy, cor);
			}

		}

		desenhar();
		repaint();
	}
}