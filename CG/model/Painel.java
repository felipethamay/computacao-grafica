package model;

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

import javax.swing.JPanel;

public class Painel extends JPanel {

	private static final long serialVersionUID = 1L;
	public BufferedImage buffimagem;

	/**
	 * Construtor 1 Recebe como parametro o valor de x
	 * 
	 * @param x            Recebe como parametro o valor de y
	 * @param y            Tem como parametro a matriz da imagem
	 * @param matrizImagem
	 */
	public Painel(int x, int y, int[][] matrizImagem) {
		setSize(x + 4, y + 4);
		buffimagem = new BufferedImage(x, y, BufferedImage.TYPE_BYTE_GRAY);
		altera(x, y, buffimagem);
		imagem(matrizImagem);

	}

	/**
	 * Construtor 2 Para o painel das imagens
	 * 
	 * @param matrizImagem
	 */
	public Painel(int[][] matrizImagem) {
		setSize(400 + 4, 292 + 4);
		buffimagem = new BufferedImage(400, 292, BufferedImage.TYPE_BYTE_GRAY);
		altera(400, 292, buffimagem);
		desenhaHistograma(matrizImagem);

	}

	/**
	 * Tem como parametro o valor de x
	 * 
	 * @param x          Tem como parametro o valor de y
	 * @param y          Tem como parametro o buffimagem da subclasse
	 *                   java.awt.Image, que usa um bloco de memória para armazenar
	 *                   a imagem a ser manipulada
	 * @param buffimagem
	 */
	public static void altera(int x, int y, BufferedImage buffimagem) {
		Graphics2D g = buffimagem.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, x, y);

	}

	/**
	 * Desenha o grafico
	 */
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(buffimagem, 2, 2, this);

	}

	/**
	 * Tem como parametro a imagem a ser equalizada
	 * 
	 * @param matrizImagem
	 */
	public void imagem(int[][] matrizImagem) {
		WritableRaster wr = buffimagem.getRaster();
		int[] cor = new int[3];
		for (int i = 0; i < matrizImagem.length; i++) {

			for (int j = 0; j < matrizImagem[0].length; j++) {
				cor[0] = matrizImagem[j][i];
				cor[1] = matrizImagem[j][i];
				cor[2] = matrizImagem[j][i];
				wr.setPixel(i, j, cor);

			}
		}

	}

	/**
	 * Desenha o grafico do histograma Tem como parametro a matriz a ser equalizada
	 * 
	 * @param matriz
	 */
	private void desenhaHistograma(int[][] matriz) {
		Graphics2D g = buffimagem.createGraphics();
		g.setColor(Color.BLACK);
		g.drawLine(20, 0, 20, 291);
		g.drawLine(0, 280, 399, 280);

		for (int k = 0; k < 256; k++) {

			int quantidade = 0;
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[0].length; j++) {
					if (matriz[i][j] == k) {
						quantidade += 1;

					}

				}

			}

			int porcento = (int) Math.round(((quantidade * 2500) / (matriz.length * matriz[0].length)));
			if (porcento > 280) {
				porcento = 280;
			}

			g.drawLine(k + 40, 280 - porcento, k + 40, 280);

		}

	}

}