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

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GatodeArnold {

	// atributos
	private int[][] img;
	private int[][] copiaImg;
	private int[][] arnold;
	private LerArquivo imagem;
	private int iteracoes;
	private ArrayList<ImageIcon> imagensGeradas = new ArrayList<ImageIcon>();

	// construtor
	public GatodeArnold(LerArquivo img) {
		this.img = img.pixels;
		this.arnold = new int[this.img.length][this.img[0].length];
		this.imagem = img;
		this.iteracoes = 0;
		this.createCopy();

	}

	/**
	 * Verifica se a imagem no array é igual a original
	 * 
	 * @param matrizA
	 * @param matrizB
	 * @return
	 */
	private boolean igual(int[][] matrizA, int[][] matrizB) {
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				if (matrizA[i][j] != matrizB[i][j])
					return false;
			}
		}
		return true;
	}

	/**
	 * Cria uma copia da imagem atual
	 */
	private void createCopy() {
		this.copiaImg = new int[img.length][img[0].length];
		for (int i = 0; i < copiaImg.length; i++) {
			for (int j = 0; j < copiaImg[i].length; j++) {
				copiaImg[i][j] = img[i][j];
			}
		}
	}

	/**
	 * Metodo que calcula a transformação
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> processaUmaVez() {
		int x = 0;
		int y = 0;

		while (!this.igual(this.img, this.arnold)) {
			this.iteracoes++;

			for (int i = 0; i < arnold.length; i++) {
				for (int j = 0; j < arnold[i].length; j++) {
					x = ((i + j) % img.length);
					y = ((j + 2 * i) % img[0].length);
					arnold[x][y] = copiaImg[i][j];
				}
			}

			for (int i = 0; i < copiaImg.length; i++) {
				for (int j = 0; j < copiaImg[i].length; j++) {
					copiaImg[i][j] = arnold[i][j];
				}
			}

			ImageIcon iconPGM = new ImageIcon(getArnoldImage().criar());
			imagensGeradas.add(iconPGM);

		}
		return imagensGeradas;

	}

	/**
	 * Chama a classe lerAqruivo
	 * 
	 * @return
	 */
	public LerArquivo getArnoldImage() {
		return new LerArquivo(this.imagem.largura, this.imagem.altura, this.imagem.maxValue, this.arnold);
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public int getIteracoes() {
		return this.iteracoes;
	}

	/**
	 * Getters and setters
	 * 
	 * @return
	 */
	public ArrayList<ImageIcon> getImagensGeradas() {
		return imagensGeradas;
	}
}