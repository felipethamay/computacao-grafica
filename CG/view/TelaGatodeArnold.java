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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.GatodeArnold;
import model.LerArquivo;

public class TelaGatodeArnold extends JFrame implements ActionListener {

	public static void main(String args[]) {
		TelaGatodeArnold ga = new TelaGatodeArnold();
		ga.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

	public JPanel pAux_arit1 = new JPanel(new BorderLayout());
	public JPanel pAux_arit2 = new JPanel(new BorderLayout());
	public JPanel pAux_arit_geral = new JPanel(new BorderLayout());
	public JPanel pAux_log1 = new JPanel(new BorderLayout());
	public JPanel pAux_log2 = new JPanel(new BorderLayout());
	public JPanel pAux_log_geral = new JPanel(new BorderLayout());
	public JPanel pAux_arit_geral1 = new JPanel(new BorderLayout());
	public JPanel pAux_arit_geral2 = new JPanel(new BorderLayout());
	private JButton buttonAbrir = new JButton("Abrir");

	private JButton buttonIniciar = new JButton("Iniciar");
	private JFileChooser file;
	private JPanel panel = new JPanel();
	private JPanel panel1;
	private JLabel label1;
	private JInternalFrame internalFrame;
	private ArrayList<ImageIcon> imageGato = new ArrayList<ImageIcon>();
	private Timer timer;
	private JScrollPane scrollPane;
	private JPanel panel2;

	public static LerArquivo PGM, PGM2, PGM_copia, PGM2_copia, PGM_soma, PGM_sub, PGM_mul, PGM_div, PGM_and, PGM_or,
			PGM_xor, PGM_not, PGM_neg, PGM_a_o_x, PGM_a_o_x2;

	public static BufferedImage BF_PGM, BF_PGM2, BF_PGM_soma, BF_PGM_sub, BF_PGM_div, BF_PGM_mul, BF_PGM_r, BF_PGM_not,
			BF_PGM_neg;

	int cont = -1;

	public TelaGatodeArnold() {
		setTitle("Transformação - Gato de Arnold");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/logo.jpg")));
		initialize();
		setResizable(false);
	}

	/**
	 * Método principal responsável por toda execução da classe
	 */
	public void initialize() {
		setSize(714, 480);
		this.setLocationRelativeTo(null);
		getContentPane().add(panel);

		panel.setLayout(null);
		buttonIniciar.setBounds(459, 32, 95, 24);
		panel.add(buttonIniciar);
		buttonAbrir.setBounds(120, 32, 97, 24);
		panel.add(buttonAbrir);

		panel2 = new JPanel();

		internalFrame = new JInternalFrame("Transforma\u00E7\u00E3o");
		internalFrame.setBounds(385, 79, 257, 320);
		panel.add(internalFrame);

		scrollPane = new JScrollPane(panel2);
		scrollPane.createHorizontalScrollBar();
		scrollPane.createVerticalScrollBar();
		internalFrame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		internalFrame.getContentPane().add(scrollPane);

		internalFrame_1 = new JInternalFrame("Imagem Original");
		internalFrame_1.setBounds(42, 79, 257, 320);
		panel.add(internalFrame_1);
		internalFrame_1.getContentPane().setLayout(null);

		label1 = new JLabel("");
		label1.setBounds(0, 0, 256, 291);
		internalFrame_1.getContentPane().add(label1);

		panel1 = new JPanel();
		panel1.setBounds(0, 0, 256, 291);
		internalFrame_1.getContentPane().add(panel1);
		panel1.setLayout(null);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);

		buttonAbrir.addActionListener(this);
		buttonIniciar.addActionListener(this);
		setVisible(true);

	}

	int aux = 0;
	int ind = 0;
	private JInternalFrame internalFrame_1;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(buttonAbrir)) {
			file = new JFileChooser();
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			file.setSize(640, 520);
			int returnVal = file.showOpenDialog(TelaGatodeArnold.this);

			if (returnVal == JFileChooser.CANCEL_OPTION) {
				return;

			} else {
				panel1.setLocation(30, 92);
				cont++;
				if (cont == 0) {
					try {
						PGM = new LerArquivo(String.valueOf(file.getSelectedFile()));
						PGM_copia = PGM;
						PGM_a_o_x = PGM;
						BF_PGM = PGM.criar();
					} catch (Exception e1) {
						System.out.println(e1);
					}

					ImageIcon iconPGM = new ImageIcon(BF_PGM);

					label1.setIcon(iconPGM);
					label1.setVisible(true);

				} else if (cont == 1) {
					try {
						PGM2 = new LerArquivo(String.valueOf(file.getSelectedFile()));
						PGM2_copia = atribui(PGM2);
						PGM_a_o_x2 = PGM2;
						BF_PGM2 = PGM2.criar();
					} catch (Exception e1) {
						System.out.println(e1);
					}

				}
			}
		} else if (e.getSource().equals(buttonIniciar)) {
			GatodeArnold gato = new GatodeArnold(PGM);
			imageGato = gato.processaUmaVez();

			timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				public void run() {

					JLabel label2 = new JLabel();
					label2.setBounds(ind, 0, 256, 256);
					panel2.add(label2);

					label2.setIcon(imageGato.get(aux));
					aux++;
					ind = ind + 260;

					if (aux == imageGato.size()) {
						timer.cancel();
						aux = 0;
					}

				}
			}, 100, 180);
		}

	}

	private LerArquivo atribui(LerArquivo imagem) {
		int[][] pixels = new int[imagem.largura][imagem.altura];
		for (int i = 0; i < imagem.largura; i++) {
			for (int j = 0; j < imagem.altura; j++) {
				pixels[i][j] = imagem.pixels[i][j];
			}
		}
		LerArquivo imgAux = new LerArquivo(imagem.largura, imagem.altura, imagem.maxValue, pixels);
		return imgAux;
	}

	public LerArquivo aplica_na_imagem(LerArquivo imagem) {
		int mask[][] = { { -1, -1, -1 }, { 0, 0, 0 }, { 1, 1, 1 } };
		float windowSize = 3, windowDiv2 = 1;
		int ai, af, bi, bf;
		double Gy;
		LerArquivo imagemR = new LerArquivo(imagem.largura, imagem.altura, imagem.maxValue, imagem.pixels);

		for (int x = 0; x < imagem.largura; x++) {
			for (int y = 0; y < imagem.altura; y++) {
				if (x < windowDiv2) {
					ai = (int) ((windowDiv2) - x);
					af = (int) (windowSize - 1);
				} else if (x > imagem.altura - 1 - windowDiv2) {
					ai = 0;
					af = (int) ((windowSize - 1) - (x - (imagem.altura - 1 - windowDiv2)));
				} else {
					ai = 0;
					af = (int) (windowSize - 1);
				}

				if (y < windowDiv2) {
					bi = (int) ((windowDiv2) - y);
					bf = (int) (windowSize - 1);
				} else if (y > imagem.largura - 1 - windowDiv2) {
					bi = 0;
					bf = (int) ((windowSize - 1) - (y - (imagem.largura - 1 - windowDiv2)));
				} else {
					bi = 0;
					bf = (int) (windowSize - 1);
				}

				double intensity;

				Gy = 0;
				for (int a = ai; a <= af; a++) {
					for (int b = bi; b <= bf; b++) {
						intensity = imagem.pixels[(int) (x - windowDiv2 + a)][(int) (y - windowDiv2 + b)];
						Gy += mask[b][a] * intensity;
					}
				}
				intensity = (Math.abs(Gy) + Math.abs(Gy));

				imagemR.pixels[x][y] = (int) intensity;
			}
		}

		return imagemR;
	}
}
