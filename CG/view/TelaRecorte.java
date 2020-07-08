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
import javax.swing.border.EmptyBorder;

import model.RecorteArea;
import model.RetaRecorte;

public class TelaRecorte extends JFrame {

	// default serial version
	private static final long serialVersionUID = 1L;

	// atributos
	private JPanel contentPane;

	private JButton jButton1 = new JButton();
	private JButton jButton2 = new JButton();
	private JButton jButton3 = new JButton();
	private JLabel jLabel1 = new JLabel();
	private JLabel jLabel2 = new JLabel();
	private JLabel jLabel3 = new JLabel();
	private JLabel jLabel4 = new JLabel();
	private JLabel jLabel5 = new JLabel();
	private JTextField jTextField1 = new JTextField();
	private JTextField jTextField2 = new JTextField();
	private JTextField jTextField3 = new JTextField();
	private JTextField jTextField4 = new JTextField();
	RetaRecorte[] retas = new RetaRecorte[20];
	RecorteArea areadeRecorte;
	private final JButton btnLimpar = new JButton("Limpar");

	// Construtor
	public TelaRecorte() {
		setTitle("Recorte Cohen-Sutherland");
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
		setBounds(100, 100, 900, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("ViewPort");
		internalFrame.setBounds(224, 12, 637, 511);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		TelaPainel telaPainelRecorte = new TelaPainel();
		telaPainelRecorte.setBounds(0, 0, 632, 484);
		internalFrame.getContentPane().add(telaPainelRecorte);
		jButton3.setBounds(36, 373, 141, 24);
		contentPane.add(jButton3);

		jButton3.setText("Aplicar Recorte");
		jButton2.setBounds(29, 302, 160, 24);
		contentPane.add(jButton2);

		jButton2.setText("Area do Recorte");
		jLabel5.setBounds(39, 237, 54, 14);
		contentPane.add(jLabel5);
		jLabel5.setText("Ymax = ");
		jTextField4.setBounds(106, 235, 71, 18);
		contentPane.add(jTextField4);
		jLabel4.setBounds(36, 199, 55, 14);
		contentPane.add(jLabel4);
		jLabel4.setText("Ymin =");
		jTextField3.setBounds(106, 197, 71, 18);
		contentPane.add(jTextField3);
		jLabel3.setBounds(39, 160, 55, 14);
		contentPane.add(jLabel3);
		jLabel3.setText("Xmax = ");
		jTextField2.setBounds(106, 158, 71, 18);
		contentPane.add(jTextField2);
		jTextField1.setBounds(106, 123, 71, 18);
		contentPane.add(jTextField1);
		jLabel2.setBounds(39, 125, 52, 14);
		contentPane.add(jLabel2);
		jLabel2.setText("Xmin = ");
		jLabel1.setBounds(36, 92, 111, 14);
		contentPane.add(jLabel1);

		jLabel1.setText("Definir Recorte:");
		jButton1.setBounds(29, 33, 160, 24);
		contentPane.add(jButton1);
		jButton1.setText("Plotar Retas");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				TelaPainel.altera();
				repaint();
			}
		});
		btnLimpar.setBounds(47, 447, 117, 24);

		contentPane.add(btnLimpar);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		internalFrame.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - 902) / 2, (screenSize.height - 565) / 2, 884, 570);
	}

	private void jButton1ActionPerformed(ActionEvent evt) {
		int x1 = TelaPainel.sorteiaX();
		int y1 = TelaPainel.sorteiaY();
		int x2 = TelaPainel.sorteiaX();
		int y2 = TelaPainel.sorteiaY();

		RetaRecorte reta1 = new RetaRecorte(x1, y1, x2, y2);
		addRetas(reta1);

		int dcx1 = TelaPainel.transformaPontosX(x1);
		int dcy1 = TelaPainel.transformaPontosY(y1);
		int dcx2 = TelaPainel.transformaPontosX(x2);
		int dcy2 = TelaPainel.transformaPontosY(y2);

		TelaPainel.setReta(dcx1, dcy1, dcx2, dcy2);

		repaint();

	}

	private void jButton2ActionPerformed(ActionEvent evt) {
		int Xmin = Integer.parseInt(jTextField1.getText());
		int Xmax = Integer.parseInt(jTextField2.getText());
		int Ymin = Integer.parseInt(jTextField3.getText());
		int Ymax = Integer.parseInt(jTextField4.getText());

		int dcxmin = TelaPainel.transformaPontosX(Xmin);
		int dcxmax = TelaPainel.transformaPontosX(Xmax);
		int dcymin = TelaPainel.transformaPontosY(Ymin);
		int dcymax = TelaPainel.transformaPontosY(Ymax);

		areadeRecorte = new RecorteArea(Xmin, Xmax, Ymin, Ymax);

		TelaPainel.desenhaAreaRecorte(dcxmin, dcxmax, dcymin, dcymax);

		repaint();

	}

	private void jButton3ActionPerformed(ActionEvent evt) {
		TelaPainel.altera();

		int dcxmin = TelaPainel.transformaPontosX(areadeRecorte.getXmin());
		int dcxmax = TelaPainel.transformaPontosX(areadeRecorte.getXmax());
		int dcymin = TelaPainel.transformaPontosY(areadeRecorte.getYmin());
		int dcymax = TelaPainel.transformaPontosY(areadeRecorte.getYmax());

		TelaPainel.desenhaAreaRecorte(dcxmin, dcxmax, dcymin, dcymax);

		repaint();

		for (int i = 0; i < retas.length; i++) {

			if (retas[i] == null) {

			} else {

				retas[i] = RecorteArea.algoritmoRecorte(retas[i], areadeRecorte);
				if (retas[i] == null) {

				} else {

					int dcx1 = TelaPainel.transformaPontosX(retas[i].getX1());
					int dcy1 = TelaPainel.transformaPontosY(retas[i].getY1());
					int dcx2 = TelaPainel.transformaPontosX(retas[i].getX2());
					int dcy2 = TelaPainel.transformaPontosY(retas[i].getY2());

					TelaPainel.setReta(dcx1, dcy1, dcx2, dcy2);

				}

			}

		}
		repaint();

	}

	public void addRetas(RetaRecorte reta1) {
		for (int i = 0; i < retas.length; i++) {
			if (retas[i] == null) {
				retas[i] = reta1;
				break;
			}

		}
	}

}
