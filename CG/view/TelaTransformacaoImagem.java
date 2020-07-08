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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.LerArquivo;
import model.OperacoesFiltros;
import model.Painel;

public class TelaTransformacaoImagem extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// Atributos
	private JPanel contentPane;

	public int[][] matrizImagem;
	public int[][] matrizImagemFinal;
	public int[][] matrizImagemFinal1;
	public int[][] matrizImagemFinal2;
	private JTextField textField;

	// Construtor
	public TelaTransformacaoImagem() {
		setTitle("Transformacao Imagem");
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
		setBounds(100, 100, 615, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(208, 12, 196, 33);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione a Transformação...", "Negativo", "Gamma", "Logaritmo" }));

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
				int returnVal = fc.showOpenDialog(TelaTransformacaoImagem.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File file = fc.getSelectedFile();
						String filepath = file.getAbsolutePath();

						LerArquivo.verificaImagem(filepath);
						int largura = LerArquivo.largura(filepath);
						int altura = LerArquivo.altura(filepath);
						matrizImagem = LerArquivo.pixels(filepath, largura, altura);
						Painel imagemOriginal = new Painel(largura, altura, matrizImagem);
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
		textField.setBounds(32, 373, 229, 24);
		contentPane.add(textField);
		internalFrameImagemFinal.setVisible(true);
		buttonAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				panelImagemFinal.removeAll();
				panelImagemFinal.repaint();
				comboBox.repaint();

				if (comboBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione a Transformação.");

				} else if (comboBox.getSelectedIndex() == 1) {
					panelImagemFinal.removeAll();
					panelImagemFinal.repaint();
					matrizImagemFinal = OperacoesFiltros.negativo(matrizImagem);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(20, 20);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);
					panelImagemFinal.repaint();

				} else if (comboBox.getSelectedIndex() == 2) {
					panelImagemFinal.removeAll();
					panelImagemFinal.repaint();
					String entA = JOptionPane.showInputDialog(null, "Digite o valor de a entre 0 e 1");
					entA = entA.replace(',', '.');
					double a = Double.parseDouble(entA);

					if (a < 0 || a > 1) {

						JOptionPane.showMessageDialog(null, "Digite um valor entre 0 e 1");

					} else {

						matrizImagemFinal = OperacoesFiltros.gamma(matrizImagem, a);
						Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
								matrizImagemFinal);
						imagemFinal.setLocation(20, 20);
						panelImagemFinal.setLayout(null);
						panelImagemFinal.add(imagemFinal);
						panelImagemFinal.repaint();

					}

				} else {
					panelImagemFinal.removeAll();
					panelImagemFinal.repaint();
					String entA = JOptionPane.showInputDialog(null, "Digite o valor de 'a':");

					int a = Integer.parseInt(entA);

					matrizImagemFinal = OperacoesFiltros.logaritmo(matrizImagem, a);
					Painel imagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
							matrizImagemFinal);
					imagemFinal.setLocation(20, 20);
					panelImagemFinal.setLayout(null);
					panelImagemFinal.add(imagemFinal);
					panelImagemFinal.repaint();

				}

				panelImagemFinal.repaint();

				repaint();
			}

		});
	}
}