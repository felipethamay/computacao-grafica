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

import java.awt.Dimension;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.RetaPM2D;
import model.Transformacoes2D;

public class TelaRotacao extends JFrame {

	// defaul serial version
	private static final long serialVersionUID = 1L;

	// Atributos
	private JPanel painel;
	private JButton jButtonAdicionar;
	private JButton jButtonDesenhar;
	private JLabel jLabelAdicionarPontos;
	private JLabel jLabelX;
	private JLabel jLabelY;
	private JLabel jLabelPontos;
	private JScrollPane jScrollPane1;
	public JTable jTable1;
	private JTextField jTextField1;
	private JTextField jTextField2;

	public JLabel textoTrans;
	public JLabel jLabelTx;
	public JLabel jLabelTy;
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
	private JButton btnAplicar;
	private JButton btnLimpar;

	// Construtor
	public TelaRotacao() {
		setTitle("Transformação - Rotação");
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		jLabelPontos = new JLabel();
		jLabelPontos.setBounds(25, 147, 77, 15);
		jLabelPontos.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelPontos.setText("Pontos:");
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setBounds(25, 168, 163, 136);
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
		jLabelAdicionarPontos = new javax.swing.JLabel();
		jLabelAdicionarPontos.setBounds(25, 20, 163, 15);
		jLabelAdicionarPontos.setText("Adicionar Pontos");
		jButtonAdicionar = new JButton();
		jButtonAdicionar.setBounds(25, 99, 105, 25);
		jButtonAdicionar.setText("Adicionar");
		jButtonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonAdicionar(evt);
			}
		});
		jLabelX = new JLabel();
		jLabelX.setBounds(25, 46, 30, 14);
		jLabelX.setText("X =");
		jTextField1 = new JTextField();
		jTextField1.setBounds(51, 43, 51, 20);
		jLabelY = new JLabel();
		jLabelY.setBounds(25, 74, 30, 14);

		jLabelY.setText("Y = ");
		jTextField2 = new JTextField();
		jTextField2.setBounds(51, 71, 51, 20);
		jButtonDesenhar = new JButton();
		jButtonDesenhar.setBounds(25, 310, 105, 25);
		jButtonDesenhar.setText("Desenhar");
		jButtonDesenhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButtonDesenhar(evt);
			}
		});
		getContentPane().add(jLabelPontos);
		getContentPane().add(jScrollPane1);
		getContentPane().add(jLabelAdicionarPontos);
		getContentPane().add(jButtonAdicionar);
		getContentPane().add(jLabelX);
		getContentPane().add(jTextField1);
		getContentPane().add(jLabelY);
		getContentPane().add(jTextField2);
		getContentPane().add(jButtonDesenhar);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(250, 11, 645, 505);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		painel = new TelaPainel();
		painel.setBounds(0, 0, 643, 483);
		internalFrame.getContentPane().add(painel);

		textoTrans = new JLabel("Rotação");
		textoTrans.setBounds(25, 359, 80, 20);
		getContentPane().add(textoTrans);
		entAngulo = new JLabel("Ângulo: ");
		entAngulo.setBounds(25, 390, 70, 20);
		getContentPane().add(entAngulo);
		startAngulo = new JTextField();
		startAngulo.setSize(80, 20);
		startAngulo.setLocation(60, 60);

		btnAplicar = new JButton("OK");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rotacao();
			}
		});
		btnAplicar.setBounds(25, 443, 105, 23);
		getContentPane().add(btnAplicar);

		startAngulo = new JTextField();
		startAngulo.setBounds(25, 411, 70, 20);
		getContentPane().add(startAngulo);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
				modelo.setNumRows(0);
				jTextField1.setText("");
				jTextField1.setText("");
				TelaPainel.altera();
				repaint();
			}
		});
		btnLimpar.setBounds(25, 492, 105, 24);
		getContentPane().add(btnLimpar);
		internalFrame.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 1000) / 2, (screenSize.height - 700) / 2, 923, 557);
	}

	private void jButtonAdicionar(ActionEvent evt) {
		String entradaX = jTextField1.getText();
		int x = Integer.parseInt(entradaX);

		String entradaY = jTextField2.getText();
		int y = Integer.parseInt(entradaY);

		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

		modelo.addRow(new Object[] { x, y });

	}

	private void jButtonDesenhar(ActionEvent evt) {
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

	public void rotacao() {

		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

		String entradaAngulo = startAngulo.getText();
		int angulo = Integer.parseInt(entradaAngulo);

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

		double[][] matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.rotacao(angulo),
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