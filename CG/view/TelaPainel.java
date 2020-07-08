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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Random;

import javax.swing.JPanel;

public class TelaPainel extends JPanel {

	// default serial version
	private static final long serialVersionUID = 1L;

	// Construtor
	public TelaPainel() {
		setSize(x + 4, y + 4);
		setLocation(225, 25);
		altera();

	}

	public static int x = 640;
	public static int y = 480;
	public static BufferedImage buffimagem = new BufferedImage(x, y, BufferedImage.TYPE_BYTE_GRAY);

	public static void altera() {

		Graphics2D g = buffimagem.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, x, y);

		WritableRaster wr = buffimagem.getRaster();
		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 255;
		cor[2] = 0;

		for (int i = 0; i < x; i++) {
			wr.setPixel(i, y / 2, cor);
		}
		for (int i = 0; i < y; i++) {
			wr.setPixel(x / 2, i, cor);
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(buffimagem, 2, 2, this);

	}

	public static void setPixel(int x, int y, int cor[]) {
		WritableRaster wr = buffimagem.getRaster();
		wr.setPixel(x, y, cor);

	}

	public static void setReta(int x1, int y1, int x2, int y2) {
		Graphics2D g = buffimagem.createGraphics();
		g.setColor(Color.black);
		g.drawLine(x1, y1, x2, y2);

	}

	public static void desenhaAreaRecorte(int Xmin, int Xmax, int Ymin, int Ymax) {
		Graphics2D g = buffimagem.createGraphics();
		g.setColor(new Color(0, 125, 0));
		g.drawLine(Xmin, Ymin, Xmax, Ymin);
		g.drawLine(Xmax, Ymin, Xmax, Ymax);
		g.drawLine(Xmax, Ymax, Xmin, Ymax);
		g.drawLine(Xmin, Ymax, Xmin, Ymin);

	}

	public static int transformaPontosX(int dcx) {
		int x;
		x = (dcx * TelaPainel.x - dcx + (TelaPainel.x / 2) * TelaPainel.x - (TelaPainel.x / 2))
				/ (2 * (TelaPainel.x / 2) - 1);
		return x;

	}

	public static int transformaPontosY(int dcy) {
		int y;
		y = ((TelaPainel.y - 1) - ((TelaPainel.y / 2 - 1) + dcy));
		return y;

	}

	public static int sorteiaX() {
		Random random = new Random();
		int X = -TelaPainel.x / 2 + random.nextInt(TelaPainel.x);
		return X;

	}

	public static int sorteiaY() {
		Random random = new Random();
		int Y = -TelaPainel.y / 2 + random.nextInt(TelaPainel.y);
		return Y;

	}

}
