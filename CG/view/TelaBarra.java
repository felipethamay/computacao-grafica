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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class TelaBarra extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	static int provedora;
	static int provedorb;
	static int provedorc;
	static int provedord;
	static int e;
	static int a1;
	static int b1;
	static int c1;
	static int d1;
	private JTextField txtProvedora;
	private JTextField txtProvedorb;
	private JTextField txtProvedorc;
	private JTextField txtProvedord;

	// Construtor
	public TelaBarra() {
		setTitle("Grafico em Barra");
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
		setBounds(100, 100, 530, 375);
		final JButton ok = new JButton("Ok");
		ok.setBounds(12, 253, 62, 24);
		final JButton sair = new JButton("Sair");
		sair.setBounds(12, 289, 62, 24);

		JPanel painel1 = new JPanel();
		painel1.setLayout(null);
		painel1.add(ok);
		painel1.add(sair);
		getContentPane().add(painel1);

		final JInternalFrame internalFrame = new JInternalFrame("Resultado");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagens/logo.jpg")));
		internalFrame.setBounds(110, 22, 400, 300);
		painel1.add(internalFrame);

		JLabel lblProvedor = new JLabel("Provedor A");
		lblProvedor.setBounds(12, 22, 90, 14);
		painel1.add(lblProvedor);

		txtProvedora = new JTextField();
		txtProvedora.setBounds(12, 38, 72, 18);
		painel1.add(txtProvedora);
		txtProvedora.setColumns(10);

		JLabel lblProvedorB = new JLabel("Provedor B");
		lblProvedorB.setBounds(12, 72, 77, 14);
		painel1.add(lblProvedorB);

		txtProvedorb = new JTextField();
		txtProvedorb.setBounds(12, 87, 77, 18);
		painel1.add(txtProvedorb);
		txtProvedorb.setColumns(10);

		JLabel lblProvedorC = new JLabel("Provedor C");
		lblProvedorC.setBounds(12, 123, 77, 14);
		painel1.add(lblProvedorC);

		txtProvedorc = new JTextField();
		txtProvedorc.setBounds(12, 142, 77, 18);
		painel1.add(txtProvedorc);
		txtProvedorc.setColumns(10);

		JLabel lblProvedorD = new JLabel("Provedor D");
		lblProvedorD.setBounds(12, 183, 90, 14);
		painel1.add(lblProvedorD);

		txtProvedord = new JTextField();
		txtProvedord.setBounds(12, 197, 77, 18);
		painel1.add(txtProvedord);
		txtProvedord.setColumns(10);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				provedora = Integer.parseInt(txtProvedora.getText());
				provedorb = Integer.parseInt(txtProvedorb.getText());
				provedorc = Integer.parseInt(txtProvedorc.getText());
				provedord = Integer.parseInt(txtProvedord.getText());
				CategoryDataset dataset = TelaBarra.createDataset();
				JFreeChart chart = TelaBarra.createBarChart(dataset);
				ChartPanel panel = new ChartPanel(chart);
				panel.setPreferredSize(new Dimension(400, 300));
				internalFrame.setContentPane(panel);

				internalFrame.setVisible(true);

			}
		});

		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();

			}
		});

	}

	public static CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		e = provedora + provedorb + provedorc + provedord;
		a1 = (provedora * 100) / e;
		b1 = (provedorb * 100) / e;
		c1 = (provedorc * 100) / e;
		d1 = (provedord * 100) / e;

		String at = "" + a1;
		String bt = "" + b1;
		String ct = "" + c1;
		String dt = "" + d1;
		dataset.addValue(provedora, at + "%", "A");
		dataset.addValue(provedorb, bt + "%", "B");
		dataset.addValue(provedorc, ct + "%", "C");
		dataset.addValue(provedord, dt + "%", "D");
		return dataset;
	}

	public static JFreeChart createBarChart(CategoryDataset dataset) {
		JFreeChart chart = ChartFactory.createBarChart(null, "Variáveis", "Frequência", dataset,
				PlotOrientation.VERTICAL, true, false, false);
		return chart;
	}

}