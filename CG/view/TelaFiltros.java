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
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.FiltrosMatrizConvolucao;
import model.LerArquivo;
import model.OperacoesFiltros;
import model.OperacoesImagem;
import model.Painel;

import javax.swing.JTextField;

public class TelaFiltros extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JPanel contentPane;

	public int[][] matrizImagem1;
	public int[][] matrizImagemFinal;
	public int[][] matrizImagemFinal1;
	public int[][] matrizImagemFinal2;
	private JTextField textField;

	// Construtor
	public TelaFiltros() {
		setTitle("Filtros");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/logo.jpg")));
		initialize();
		this.setLocationRelativeTo(null);
		setResizable(false);
		this.dispose();
	}

	/**
	 * Método principal responsável por toda execução da classe
	 */
	public void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 615, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(208, 12, 196, 33);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Selecione o Filtro...", "Alto reforço", "Media",
				"Mediana", "Passa Alta Basico", "Prewtit em X", "Prewitt em Y", "Prewitt em X e Y", "Robert em X",
				"Robert em Y", "Robert em X e Y", "Robert cruzado em X", "Robert cruzado em Y",
				"Robert cruzado em X e Y", "Sobel em X", "Sobel em Y", "Sobel em X e Y" }));

		JButton buttonAbrirImagem = new JButton();
		buttonAbrirImagem.setText("Abrir Imagem");
		buttonAbrirImagem.setBounds(81, 331, 132, 33);
		contentPane.add(buttonAbrirImagem);

		JInternalFrame internalFrameImagemOriginal = new JInternalFrame("Imagem Original");
		internalFrameImagemOriginal.setBounds(32, 67, 229, 252);
		contentPane.add(internalFrameImagemOriginal);
		internalFrameImagemOriginal.getContentPane().setLayout(null);

		final JPanel panelImagemOriginal = new JPanel();
		panelImagemOriginal.setBounds(-32, -33, 256, 256);
		internalFrameImagemOriginal.getContentPane().add(panelImagemOriginal);
		GroupLayout gl_panelImagemOriginal = new GroupLayout(panelImagemOriginal);
		gl_panelImagemOriginal.setHorizontalGroup(gl_panelImagemOriginal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 333, Short.MAX_VALUE).addGap(0, 333, Short.MAX_VALUE));
		gl_panelImagemOriginal.setVerticalGroup(gl_panelImagemOriginal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 328, Short.MAX_VALUE).addGap(0, 328, Short.MAX_VALUE));
		panelImagemOriginal.setLayout(gl_panelImagemOriginal);
		internalFrameImagemOriginal.setVisible(true);
		buttonAbrirImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				panelImagemOriginal.removeAll();
				panelImagemOriginal.repaint();

				JFileChooser fc = new JFileChooser();
				fc.setSize(640, 520);
				int returnVal = fc.showOpenDialog(TelaFiltros.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File file = fc.getSelectedFile();
						String filepath = file.getAbsolutePath();

						LerArquivo.verificaImagem(filepath);
						int largura = LerArquivo.largura(filepath);
						int altura = LerArquivo.altura(filepath);
						matrizImagem1 = LerArquivo.pixels(filepath, largura, altura);
						Painel imagemOriginal = new Painel(largura, altura, matrizImagem1);
						imagemOriginal.setLocation(30, 30);

						panelImagemOriginal.setLayout(null);
						panelImagemOriginal.add(imagemOriginal);
						panelImagemOriginal.repaint();

						repaint();

						textField.setText(file.getPath());

					} catch (Exception e) {

						JOptionPane.showMessageDialog(null, e);

					}
				}
			}
		});

		JButton buttonAplicar = new JButton();
		buttonAplicar.setText("Aplicar");
		buttonAplicar.setBounds(396, 331, 132, 33);
		contentPane.add(buttonAplicar);

		JInternalFrame internalFrameImagemFinal = new JInternalFrame("Imagem Final");
		internalFrameImagemFinal.setBounds(342, 67, 229, 252);
		contentPane.add(internalFrameImagemFinal);
		internalFrameImagemFinal.getContentPane().setLayout(null);

		final JPanel panelImagemFinal = new JPanel();
		panelImagemFinal.setBounds(-37, -35, 256, 256);
		internalFrameImagemFinal.getContentPane().add(panelImagemFinal);
		GroupLayout gl_panelImagemFinal = new GroupLayout(panelImagemFinal);
		gl_panelImagemFinal.setHorizontalGroup(gl_panelImagemFinal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 345, Short.MAX_VALUE).addGap(0, 345, Short.MAX_VALUE));
		gl_panelImagemFinal.setVerticalGroup(gl_panelImagemFinal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 340, Short.MAX_VALUE).addGap(0, 340, Short.MAX_VALUE));
		panelImagemFinal.setLayout(gl_panelImagemFinal);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(32, 376, 229, 24);
		contentPane.add(textField);
		internalFrameImagemFinal.setVisible(true);
		buttonAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				panelImagemFinal.removeAll();
				panelImagemFinal.repaint();
				comboBox.repaint();

				if (comboBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione o Filtro.");

				} else if (comboBox.getSelectedIndex() == 1) {

					String entA = JOptionPane.showInputDialog(null, "Digite o valor de 'A':");
					entA = entA.replace(',', '.');
					double a = Double.parseDouble(entA);

					matrizImagemFinal = OperacoesFiltros.convolucao(matrizImagem1,
							FiltrosMatrizConvolucao.altoreforco(a));
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 2) {

					matrizImagemFinal = OperacoesFiltros.convolucao(matrizImagem1, FiltrosMatrizConvolucao.media());
					matrizImagemFinal = OperacoesImagem.normalizacao(matrizImagemFinal);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 3) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMediana(matrizImagem1);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 4) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.passaAlta());
					matrizImagemFinal = OperacoesImagem.normalizacao(matrizImagemFinal);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 5) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.prewittX());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 6) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.prewittY());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 7) {
					matrizImagemFinal1 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.prewittX());
					matrizImagemFinal2 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.prewittY());
					matrizImagemFinal = OperacoesImagem.somadeImagens(matrizImagemFinal1, matrizImagemFinal2);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 8) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertX());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 9) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertY());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 10) {
					matrizImagemFinal1 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertX());
					matrizImagemFinal2 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertY());
					matrizImagemFinal = OperacoesImagem.somadeImagens(matrizImagemFinal1, matrizImagemFinal2);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 11) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertCruzadoX());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 12) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertCruzadoY());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 13) {
					matrizImagemFinal1 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertCruzadoX());
					matrizImagemFinal2 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.robertCruzadoY());
					matrizImagemFinal = OperacoesImagem.somadeImagens(matrizImagemFinal1, matrizImagemFinal2);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 14) {
					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.sobelX());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else if (comboBox.getSelectedIndex() == 15) {

					matrizImagemFinal = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.sobelY());
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				} else {

					matrizImagemFinal1 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.sobelX());
					matrizImagemFinal2 = OperacoesFiltros.convolucaoMatrizes(matrizImagem1,
							FiltrosMatrizConvolucao.sobelY());
					matrizImagemFinal = OperacoesImagem.somadeImagens(matrizImagemFinal1, matrizImagemFinal2);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(30, 30);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);

				}

				panelImagemFinal.repaint();
				repaint();

			}
		});

	}
}
