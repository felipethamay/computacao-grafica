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
import javax.swing.JFrame;
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

public class TelaEscala extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JPanel painel;
	private JButton jButtonAdicionar;
	private JButton jButtonDesenhar;
	private JLabel jLabelAdicionarPontos;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabelPontos;
	private JScrollPane jScrollPane;
	public JTable jTable1;
	private JTextField jTextFieldX;
	private JTextField jTextFieldY;

	public JLabel jLabelEscala;
	public JLabel entX;
	public JLabel entY;
	public JLabel entAngulo;
	public JTextField jTextFieldSx;
	public JTextField jTextFieldSy;
	public JTextField startAngulo;
	public JRadioButton button1;
	public JRadioButton button2;
	public JRadioButton button3;
	public JRadioButton button4;
	public ButtonGroup grupo;
	private JButton jButtonOk;
	private JButton btnLimpar;

	// Construtor
	public TelaEscala() {
		setTitle("Transformação - Escala");
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
		jLabelPontos.setBounds(25, 147, 81, 15);

		jLabelPontos.setText("Pontos:");
		jScrollPane = new javax.swing.JScrollPane();
		jScrollPane.setBounds(25, 169, 163, 136);
		jTable1 = new javax.swing.JTable();

		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "X", "Y" }) {

			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane.setViewportView(jTable1);
		jLabelAdicionarPontos = new JLabel();
		jLabelAdicionarPontos.setBounds(25, 20, 163, 15);
		jLabelAdicionarPontos.setText("Adicionar Pontos");
		jButtonAdicionar = new JButton();
		jButtonAdicionar.setBounds(25, 99, 105, 25);

		jButtonAdicionar.setText("Adicionar");
		jButtonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jLabel2 = new JLabel();
		jLabel2.setBounds(25, 46, 29, 14);

		jLabel2.setText("X =");
		jTextFieldX = new JTextField();
		jTextFieldX.setBounds(55, 46, 51, 20);
		jLabel3 = new JLabel();
		jLabel3.setBounds(25, 74, 29, 14);

		jLabel3.setText("Y = ");
		jTextFieldY = new JTextField();
		jTextFieldY.setBounds(55, 74, 51, 20);
		jButtonDesenhar = new JButton();
		jButtonDesenhar.setBounds(25, 310, 105, 25);

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
		getContentPane().add(jLabel2);
		getContentPane().add(jTextFieldX);
		getContentPane().add(jLabel3);
		getContentPane().add(jTextFieldY);
		getContentPane().add(jButtonDesenhar);

		JInternalFrame internalFrame = new JInternalFrame("");
		internalFrame.setBounds(250, 11, 645, 507);
		getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		painel = new TelaPainel();
		painel.setBounds(0, 0, 704, 604);
		internalFrame.getContentPane().add(painel);
		repaint();
		jLabelEscala = new JLabel("Escala");
		jLabelEscala.setBounds(25, 358, 80, 20);
		getContentPane().add(jLabelEscala);
		entX = new JLabel("Sx =");
		entX.setBounds(25, 393, 40, 20);
		getContentPane().add(entX);
		jTextFieldSx = new JTextField();
		jTextFieldSx.setBounds(65, 393, 70, 20);
		getContentPane().add(jTextFieldSx);
		entY = new JLabel("Sy =");
		entY.setBounds(25, 432, 40, 20);
		getContentPane().add(entY);
		jTextFieldSy = new JTextField();
		jTextFieldSy.setBounds(65, 432, 70, 20);
		getContentPane().add(jTextFieldSy);

		jButtonOk = new JButton("OK");
		jButtonOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escala();
			}
		});
		jButtonOk.setBounds(29, 464, 105, 23);
		getContentPane().add(jButtonOk);

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
		btnLimpar.setBounds(29, 499, 105, 23);
		getContentPane().add(btnLimpar);

		internalFrame.setVisible(true);
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 1000) / 2, (screenSize.height - 700) / 2, 931, 576);
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

	public void escala() {
		DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

		String entradaSx = jTextFieldSx.getText();
		entradaSx = entradaSx.replace(',', '.');
		double Sx = Double.parseDouble(entradaSx);

		String entradaSy = jTextFieldSy.getText();
		entradaSy = entradaSy.replace(',', '.');
		double Sy = Double.parseDouble(entradaSy);

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

		double[][] matrizTrans = Transformacoes2D.multiplicaMatrizTrans(Transformacoes2D.escala(Sx, Sy),
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