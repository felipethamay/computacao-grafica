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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Histograma;
import model.LerArquivo;
import model.Painel;

import javax.swing.JTextField;

public class TelaHistograma extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JPanel contentPane;
	public int[][] matrizImagemOriginal;
	public int[][] matrizImagemFinal;
	private JTextField textField;

	// Construtor
	public TelaHistograma() {
		setTitle("Histograma");
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
		setBounds(100, 100, 692, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton JButton2 = new JButton();
		JButton2.setBounds(12, 662, 127, 29);
		JButton2.setText("Equalizar");
		contentPane.add(JButton2);

		JInternalFrame internalFrameImagemFinal = new JInternalFrame("Imagem Final");
		internalFrameImagemFinal.setBounds(12, 375, 260, 275);
		contentPane.add(internalFrameImagemFinal);
		internalFrameImagemFinal.getContentPane().setLayout(null);

		final JPanel imagemFinal = new JPanel();
		imagemFinal.setBounds(-8, 0, 256, 256);
		internalFrameImagemFinal.getContentPane().add(imagemFinal);
		imagemFinal.setLayout(null);
		internalFrameImagemFinal.setVisible(true);

		JInternalFrame internalFrameHistogramaFinal = new JInternalFrame("Histograma Final");
		internalFrameHistogramaFinal.setBounds(299, 375, 374, 307);
		contentPane.add(internalFrameHistogramaFinal);
		internalFrameHistogramaFinal.getContentPane().setLayout(null);

		final JPanel HistogramaFinal = new JPanel();
		HistogramaFinal.setBounds(-11, -17, 385, 293);
		internalFrameHistogramaFinal.getContentPane().add(HistogramaFinal);

		JButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				imagemFinal.removeAll();
				imagemFinal.repaint();
				HistogramaFinal.removeAll();
				HistogramaFinal.repaint();

				matrizImagemFinal = Histograma.equalizaImagem(matrizImagemOriginal);
				Painel painelImagemFinal = new Painel(matrizImagemFinal.length, matrizImagemFinal[0].length,
						matrizImagemFinal);
				painelImagemFinal.setLocation((imagemFinal.getHeight() - matrizImagemFinal.length + 15) / 2,
						(imagemFinal.getWidth() - matrizImagemFinal[0].length - 25) / 2);

				Painel painelhistogramaFinal = new Painel(matrizImagemFinal);
				painelhistogramaFinal.setLocation(2, 2);

				imagemFinal.setLayout(null);
				HistogramaFinal.setLayout(null);

				imagemFinal.add(painelImagemFinal);
				HistogramaFinal.add(painelhistogramaFinal);

				imagemFinal.repaint();
				HistogramaFinal.repaint();

				repaint();
			}
		});

		JInternalFrame internalFrame = new JInternalFrame("Imagem Original");
		internalFrame.setBounds(12, 12, 260, 275);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		final JPanel imagemOriginal = new JPanel();
		imagemOriginal.setBounds(-12, 0, 267, 256);
		internalFrame.getContentPane().add(imagemOriginal);
		GroupLayout gl_imagemOriginal = new GroupLayout(imagemOriginal);
		gl_imagemOriginal.setHorizontalGroup(gl_imagemOriginal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 329, Short.MAX_VALUE).addGap(0, 325, Short.MAX_VALUE));
		gl_imagemOriginal.setVerticalGroup(gl_imagemOriginal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE).addGap(0, 296, Short.MAX_VALUE));
		imagemOriginal.setLayout(gl_imagemOriginal);

		JInternalFrame internalFrameHistogramaOriginal = new JInternalFrame("Histograma Original");
		internalFrameHistogramaOriginal.setBounds(299, 12, 374, 307);
		contentPane.add(internalFrameHistogramaOriginal);
		internalFrameHistogramaOriginal.getContentPane().setLayout(null);

		final JPanel HistogramaOriginal = new JPanel();
		HistogramaOriginal.setBounds(-11, -17, 385, 300);
		internalFrameHistogramaOriginal.getContentPane().add(HistogramaOriginal);

		GroupLayout gl_HistogramaOriginal = new GroupLayout(HistogramaOriginal);
		gl_HistogramaOriginal.setHorizontalGroup(gl_HistogramaOriginal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE).addGap(0, 381, Short.MAX_VALUE));
		gl_HistogramaOriginal.setVerticalGroup(gl_HistogramaOriginal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE).addGap(0, 296, Short.MAX_VALUE));
		HistogramaOriginal.setLayout(gl_HistogramaOriginal);

		JButton JButton3 = new JButton();
		JButton3.setBounds(12, 299, 145, 29);
		contentPane.add(JButton3);
		JButton3.setText("Abrir");

		GroupLayout gl_HistogramaFinal = new GroupLayout(HistogramaFinal);
		gl_HistogramaFinal.setHorizontalGroup(gl_HistogramaFinal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE).addGap(0, 381, Short.MAX_VALUE));
		gl_HistogramaFinal.setVerticalGroup(gl_HistogramaFinal.createParallelGroup(Alignment.LEADING)
				.addGap(0, 293, Short.MAX_VALUE).addGap(0, 289, Short.MAX_VALUE));
		HistogramaFinal.setLayout(gl_HistogramaFinal);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(12, 339, 260, 24);
		contentPane.add(textField);
		internalFrameHistogramaFinal.setVisible(true);

		JButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFileChooser fc = new JFileChooser();
				fc.setSize(640, 520);
				int returnVal = fc.showOpenDialog(TelaHistograma.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						File file = fc.getSelectedFile();
						String filepath = file.getAbsolutePath();

						LerArquivo.verificaImagem(filepath);
						int largura = LerArquivo.largura(filepath);
						int altura = LerArquivo.altura(filepath);
						matrizImagemOriginal = LerArquivo.pixels(filepath, largura, altura);
						Painel painelImagemOriginal = new Painel(largura, altura, matrizImagemOriginal);
						painelImagemOriginal.setLocation((imagemOriginal.getHeight() - largura + 15) / 2,
								(imagemOriginal.getWidth() - altura - 25) / 2);

						Painel painelhistogramaOriginal = new Painel(matrizImagemOriginal);
						painelhistogramaOriginal.setLocation(2, 2);

						imagemOriginal.removeAll();
						imagemOriginal.repaint();
						HistogramaOriginal.removeAll();
						HistogramaOriginal.repaint();
						HistogramaOriginal.setLayout(null);

						imagemOriginal.setLayout(null);
						imagemOriginal.add(painelImagemOriginal);
						imagemOriginal.repaint();

						HistogramaOriginal.add(painelhistogramaOriginal);
						HistogramaOriginal.repaint();

						repaint();

						textField.setText(file.getPath());

					} catch (Exception e) {

						JOptionPane.showMessageDialog(null, e);

					}
				}

				imagemOriginal.repaint();

				repaint();
			}
		});
		internalFrameHistogramaOriginal.setVisible(true);
		internalFrame.setVisible(true);
	}

}