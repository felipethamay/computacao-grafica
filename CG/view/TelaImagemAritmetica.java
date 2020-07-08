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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import model.LerArquivo;
import model.OperacoesImagem;
import model.Painel;

import javax.swing.JTextField;

public class TelaImagemAritmetica extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// Atributos
	private JPanel contentPane;
	private ButtonGroup buttonGroup1 = new ButtonGroup();
	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JLabel jLabel = new JLabel();
	private JRadioButton jRadioButton1 = new JRadioButton();
	private JRadioButton jRadioButton2 = new JRadioButton();
	private JRadioButton jRadioButton3 = new JRadioButton();
	private JRadioButton jRadioButton4 = new JRadioButton();
	public int[][] matrizImagem1;
	public int[][] matrizImagem2;
	JInternalFrame internalFrame = new JInternalFrame("Imagem 1");
	JInternalFrame internalFrame_1 = new JInternalFrame("Imagem 2");
	JInternalFrame internalFrame_2 = new JInternalFrame("Imagem Final");
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel_2 = new JPanel();
	private final JPanel panel_3 = new JPanel();
	private final JTextField textField1 = new JTextField();
	private final JTextField textField2 = new JTextField();

	// Construtor
	public TelaImagemAritmetica() {
		setTitle("Operacao Aritimetica");
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel_3.setBounds(0, 0, 270, 270);
		internalFrame_2.getContentPane().add(panel_3);
		panel_3.setBackground(Color.WHITE);
		internalFrame_2.setBounds(589, 11, 270, 297);
		internalFrame_2.setVisible(true);

		panel_2.setBounds(0, 0, 270, 270);
		internalFrame_1.getContentPane().add(panel_2);
		panel_2.setBackground(Color.WHITE);
		internalFrame_1.setBounds(301, 11, 276, 297);
		internalFrame_1.setVisible(true);

		panel_1.setBounds(0, 0, 263, 252);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		internalFrame.setBounds(13, 11, 275, 297);
		internalFrame.setVisible(true);
		jButton1.setBounds(87, 325, 124, 24);

		jButton1.setText("Abrir");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.setBounds(371, 325, 124, 24);

		jButton2.setText("Abrir");
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.setBounds(664, 325, 124, 24);

		jButton3.setText("Aplicar");
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		internalFrame.getContentPane().setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 266, 266);

		internalFrame.getContentPane().add(panel_1);
		internalFrame_2.getContentPane().setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 266, 266);

		internalFrame_2.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		internalFrame_1.getContentPane().setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 0, 266, 266);

		internalFrame_1.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 270, 270);
		panel_1.setLayout(null);
		contentPane.add(internalFrame);
		contentPane.add(internalFrame_1);
		contentPane.add(internalFrame_2);
		contentPane.add(jButton1);
		contentPane.add(jButton2);
		contentPane.add(jButton3);
		textField1.setEditable(false);
		textField1.setColumns(10);
		textField1.setBounds(13, 361, 275, 24);

		contentPane.add(textField1);
		textField2.setEditable(false);
		textField2.setColumns(10);
		textField2.setBounds(301, 361, 276, 24);

		contentPane.add(textField2);
		jLabel.setBounds(13, 419, 161, 14);
		contentPane.add(jLabel);

		jLabel.setText("Operações Aritméticas");
		buttonGroup1.add(jRadioButton1);
		jRadioButton1.setBounds(13, 448, 56, 14);
		contentPane.add(jRadioButton1);
		jRadioButton1.setText("Soma");
		jRadioButton1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jRadioButton1.setMargin(new Insets(0, 0, 0, 0));

		buttonGroup1.add(jRadioButton2);
		jRadioButton2.setBounds(13, 497, 90, 14);
		contentPane.add(jRadioButton2);
		jRadioButton2.setText("Subtracao");
		jRadioButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jRadioButton2.setMargin(new Insets(0, 0, 0, 0));

		buttonGroup1.add(jRadioButton4);
		jRadioButton4.setBounds(175, 497, 68, 14);
		contentPane.add(jRadioButton4);
		jRadioButton4.setText("Divisao");
		jRadioButton4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jRadioButton4.setMargin(new Insets(0, 0, 0, 0));

		buttonGroup1.add(jRadioButton3);
		jRadioButton3.setBounds(175, 448, 110, 14);
		contentPane.add(jRadioButton3);
		jRadioButton3.setText("Multiplicacao");
		jRadioButton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jRadioButton3.setMargin(new Insets(0, 0, 0, 0));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 870) / 2, (screenSize.height - 576) / 2, 892, 576);
	}

	private void jButton3ActionPerformed(ActionEvent evt) {

		panel_3.removeAll();
		panel_3.repaint();

		if (buttonGroup1.getSelection() == jRadioButton1.getModel()) {

			int[][] matriz = OperacoesImagem.somadeImagens(matrizImagem1, matrizImagem2);
			Painel imagemFinal = new Painel(matriz.length, matriz[0].length, matriz);
			imagemFinal.setLocation(5, 5);
			panel_3.setLayout(null);
			panel_3.add(imagemFinal);

		} else if (buttonGroup1.getSelection() == jRadioButton2.getModel()) {

			int[][] matriz = OperacoesImagem.subtracaodeImagens(matrizImagem1, matrizImagem2);
			Painel imagemFinal = new Painel(matriz.length, matriz[0].length, matriz);
			imagemFinal.setLocation(5, 5);
			panel_3.setLayout(null);
			panel_3.add(imagemFinal);

		} else if (buttonGroup1.getSelection() == jRadioButton3.getModel()) {

			int[][] matriz = OperacoesImagem.multiplicacaodeImagens(matrizImagem1, matrizImagem2);
			Painel imagemFinal = new Painel(matriz.length, matriz[0].length, matriz);
			imagemFinal.setLocation(5, 5);
			panel_3.setLayout(null);
			panel_3.add(imagemFinal);

		} else if (buttonGroup1.getSelection() == jRadioButton4.getModel()) {

			int[][] matriz = OperacoesImagem.divisaodeImagens(matrizImagem1, matrizImagem2);
			Painel imagemFinal = new Painel(matriz.length, matriz[0].length, matriz);
			imagemFinal.setLocation(5, 5);
			panel_3.setLayout(null);
			panel_3.add(imagemFinal);

		}
	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.setSize(640, 520);
		int returnVal = fc.showOpenDialog(TelaImagemAritmetica.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fc.getSelectedFile();
				String filepath = file.getAbsolutePath();

				LerArquivo.verificaImagem(filepath);
				int largura = LerArquivo.largura(filepath);
				int altura = LerArquivo.altura(filepath);
				matrizImagem2 = LerArquivo.pixels(filepath, largura, altura);
				Painel imagem2 = new Painel(largura, altura, matrizImagem2);
				imagem2.setLocation(5, 5);

				panel_2.setLayout(null);
				panel_2.add(imagem2);
				panel_2.repaint();

				textField2.setText(file.getPath());

			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, e);

			}
		}
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.setSize(640, 480);
		int returnVal = fc.showOpenDialog(TelaImagemAritmetica.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File file = fc.getSelectedFile();
				String filepath = file.getAbsolutePath();

				LerArquivo.verificaImagem(filepath);
				int largura = LerArquivo.largura(filepath);
				int altura = LerArquivo.altura(filepath);
				matrizImagem1 = LerArquivo.pixels(filepath, largura, altura);
				Painel imagem1 = new Painel(largura, altura, matrizImagem1);
				imagem1.setLocation(5, 5);

				panel_1.setLayout(null);
				panel_1.add(imagem1);
				panel_1.repaint();

				textField1.setText(file.getPath());

			} catch (Exception ex) {

				System.out.println(ex);

			}
		}

	}
}