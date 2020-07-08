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

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JPanel contentPane;
	TelaInicial inicio;

	/**
	 * Método que executa a tela inicial
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TelaInicial inicio = new TelaInicial();
				inicio.setVisible(true);
			}
		});
	}

	// Construtor
	public TelaInicial() {
		setTitle("Computacao Grafica");
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
		setBounds(100, 100, 500, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logo = new JLabel("");
		logo.setBounds(0, 0, 492, 326);
		logo.setIcon(new ImageIcon(getClass().getResource("imagens/logoCG.jpg")));
		contentPane.add(logo);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);

		JMenuItem menuItemSair = new JMenuItem("Sair");
		menuArquivo.add(menuItemSair);
		menuItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JMenu mnComputacaoGrafica = new JMenu("Computação Gráfica");
		menuBar.add(mnComputacaoGrafica);

		JMenu mnConversao = new JMenu("Conversão");
		mnComputacaoGrafica.add(mnConversao);

		JMenuItem mntmReta = new JMenuItem("Reta");
		mntmReta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRetas re = new TelaRetas();
				re.setVisible(true);
			}
		});
		mnConversao.add(mntmReta);

		JMenuItem mntmElispe = new JMenuItem("Elipse");
		mntmElispe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaElipse el = new TelaElipse();
				el.setVisible(true);
			}
		});
		mnConversao.add(mntmElispe);

		JMenuItem mntmCincunferencia = new JMenuItem("Circunferência");
		mntmCincunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCircunferencia ci = new TelaCircunferencia();
				ci.setVisible(true);
			}
		});
		mnConversao.add(mntmCincunferencia);

		JMenu menu = new JMenu("Gráfico");
		mnComputacaoGrafica.add(menu);

		JMenuItem mntmBarra = new JMenuItem("Barra");
		mntmBarra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaBarra ba = new TelaBarra();
				ba.setVisible(true);
			}
		});
		menu.add(mntmBarra);

		JMenuItem mntmColuna = new JMenuItem("Coluna");
		mntmColuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaColuna co = new TelaColuna();
				co.setVisible(true);
			}
		});
		menu.add(mntmColuna);

		JMenuItem mntmPizza = new JMenuItem("Pizza");
		mntmPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPizza pi = new TelaPizza();
				pi.setVisible(true);
			}
		});
		menu.add(mntmPizza);

		JMenuItem mntmAnimacao = new JMenuItem("Animação");
		mntmAnimacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAnimacao an = new TelaAnimacao();
				an.setVisible(true);
			}
		});
		mnComputacaoGrafica.add(mntmAnimacao);

		JMenuItem mntmRecorte = new JMenuItem("Recorte");
		mntmRecorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRecorte re = new TelaRecorte();
				re.setVisible(true);
			}
		});
		mnComputacaoGrafica.add(mntmRecorte);

		JMenu mnTransformacoes = new JMenu("Transformações");
		mnComputacaoGrafica.add(mnTransformacoes);

		JMenu mnd = new JMenu("2D");
		mnTransformacoes.add(mnd);

		JMenuItem mntmTranslacao = new JMenuItem("Translação");
		mntmTranslacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTranslacao tr = new TelaTranslacao();
				tr.setVisible(true);
			}
		});
		mnd.add(mntmTranslacao);

		JMenuItem mntmRotacao = new JMenuItem("Rotação");
		mntmRotacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRotacao ro = new TelaRotacao();
				ro.setVisible(true);
			}
		});
		mnd.add(mntmRotacao);

		JMenuItem mntmEscala = new JMenuItem("Escala");
		mntmEscala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscala es = new TelaEscala();
				es.setVisible(true);
			}
		});
		mnd.add(mntmEscala);

		JMenuItem mntmReflexao = new JMenuItem("Reflexão");
		mntmReflexao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReflexao re = new TelaReflexao();
				re.setVisible(true);
			}
		});
		mnd.add(mntmReflexao);

		JMenuItem mntmCisalhamento = new JMenuItem("Cisalhamento");
		mntmCisalhamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCisalhamento ci = new TelaCisalhamento();
				ci.setVisible(true);
			}
		});
		mnd.add(mntmCisalhamento);

		JMenu mnNewMenu = new JMenu("Processamento de Imagens");
		menuBar.add(mnNewMenu);

		JMenuItem mntmFiltros = new JMenuItem("Filtros");
		mntmFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFiltros fi = new TelaFiltros();
				fi.setVisible(true);
			}
		});

		mnNewMenu.add(mntmFiltros);

		JMenu mnOperacoesImagens = new JMenu("Operações Imagens");
		mnNewMenu.add(mnOperacoesImagens);

		JMenuItem mntmAritmetica = new JMenuItem("Aritmética");
		mntmAritmetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaImagemAritmetica ar = new TelaImagemAritmetica();
				ar.setVisible(true);
			}
		});
		mnOperacoesImagens.add(mntmAritmetica);

		JMenuItem mntmLogica = new JMenuItem("Lógica");
		mntmLogica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaImagemLogica lo = new TelaImagemLogica();
				lo.setVisible(true);
			}
		});
		mnOperacoesImagens.add(mntmLogica);

		JMenuItem mntmGatoDeArnold = new JMenuItem("Gato de Arnold");
		mntmGatoDeArnold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGatodeArnold ga = new TelaGatodeArnold();
				ga.setVisible(true);
			}
		});
		mnNewMenu.add(mntmGatoDeArnold);

		JMenuItem mntmTransformacaoImagens = new JMenuItem("Transformação Imagens");
		mntmTransformacaoImagens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTransformacaoImagem tr = new TelaTransformacaoImagem();
				tr.setVisible(true);
			}
		});
		mnNewMenu.add(mntmTransformacaoImagens);

		JMenuItem mntmHistograma = new JMenuItem("Histograma");
		mntmHistograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaHistograma hi = new TelaHistograma();
				hi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmHistograma);

		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);

		final JMenuItem mntmInstrues = new JMenuItem("Instruções");
		mntmInstrues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(mntmInstrues, "Abra o Manual.pdf disponível na pasta do programa.");

			}
		});
		menuAjuda.add(mntmInstrues);

		JMenuItem menuItemCreditos = new JMenuItem("Créditos");
		menuAjuda.add(menuItemCreditos);
		menuItemCreditos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				TelaCreditos t1 = new TelaCreditos();
				t1.setVisible(true);
			}
		});

	}
}