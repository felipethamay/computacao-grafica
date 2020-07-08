package model;

/**
 * Universidade Estadual da Paraiba Departamento de Computacao Curso de
 * Licenciatura Plena em Computacao Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno Equipe: Arthur Felipe Thamay Medeiros, Jefferson
 * Felipe Silva de Lima, Thalles Gutembergh dos Santos 2012.2
 */

public class OperacoesImagem {

	/**
	 * Metodo que executa a operação de soma das matrizes das imagens
	 * 
	 * Tem como parametro a matriz da primeira imagem selecionada
	 * 
	 * @param matrizImagem1 Tem como parametro a matriz da segunda imagem
	 *                      selecionada
	 * @param matrizImagem2 Retorna a matriz operada
	 * @return
	 */
	public static int[][] somadeImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
		for (int i = 0; i < matrizImagemFinal.length; i++) {
			for (int j = 0; j < matrizImagemFinal.length; j++) {
				matrizImagemFinal[i][j] = matrizImagem1[i][j] + matrizImagem2[i][j];

			}
		}

		matrizImagemFinal = normalizacao(matrizImagemFinal);
		return matrizImagemFinal;

	}

	/**
	 * Metodo que executa a operação de subtração das matrizes das imagens
	 * 
	 * Tem como parametro a matriz da primeira imagem selecionada
	 * 
	 * @param matrizImagem1 Tem como parametro a matriz da segunda imagem
	 *                      selecionada
	 * @param matrizImagem2 Retorna a matriz operada
	 * @return
	 */
	public static int[][] subtracaodeImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
		for (int i = 0; i < matrizImagemFinal.length; i++) {
			for (int j = 0; j < matrizImagemFinal.length; j++) {
				matrizImagemFinal[i][j] = matrizImagem1[i][j] - matrizImagem2[i][j];

			}

		}

		matrizImagemFinal = normalizacao(matrizImagemFinal);
		return matrizImagemFinal;

	}

	/**
	 * Metodo que executa a operação de multiplicação das matrizes das imagens
	 * 
	 * Tem como parametro a matriz da primeira imagem selecionada
	 * 
	 * @param matrizImagem1 Tem como parametro a matriz da segunda imagem
	 *                      selecionada
	 * @param matrizImagem2 Retorna a matriz operada
	 * @return
	 */

	public static int[][] multiplicacaodeImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
		for (int i = 0; i < matrizImagemFinal.length; i++) {
			for (int j = 0; j < matrizImagemFinal.length; j++) {
				matrizImagemFinal[i][j] = matrizImagem1[i][j] * matrizImagem2[i][j];

			}

		}

		matrizImagemFinal = normalizacao(matrizImagemFinal);
		return matrizImagemFinal;
	}

	/**
	 * Metodo que executa a operação de divisão das matrizes das imagens
	 * 
	 * Tem como parametro a matriz da primeira imagem selecionada
	 * 
	 * @param matrizImagem1 Tem como parametro a matriz da segunda imagem
	 *                      selecionada
	 * @param matrizImagem2 Retorna a matriz operada
	 * @return
	 */

	public static int[][] divisaodeImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
		for (int i = 0; i < matrizImagemFinal.length; i++) {
			for (int j = 0; j < matrizImagemFinal.length; j++) {
				if (matrizImagem2[i][j] == 0) {
					matrizImagemFinal[i][j] = 0;
				} else {
					matrizImagemFinal[i][j] = (int) Math.round(matrizImagem1[i][j] / matrizImagem2[i][j]);

				}

			}

		}

		matrizImagemFinal = normalizacao(matrizImagemFinal);
		return matrizImagemFinal;

	}

	/**
	 * Converte os valores da matriz de decimal para binario para ser feita a
	 * operação logica Tem como parametro um valor em decimal
	 * 
	 * @param decimal Retorna o valor decimal convertido em binario
	 * @return
	 */

	public static String intBinario(int decimal) {
		String binario = "";
		int aux = decimal;
		while (aux > 1) {
			binario += "" + (aux % 2);
			aux = (int) Math.floor(aux / 2);

		}

		binario += "" + aux;
		int tamanho = binario.length();
		int vezes = 8 - tamanho;

		if (binario.length() < 8) {
			for (int i = 0; i < vezes; i++) {
				binario += "0";

			}

		}

		String bin = "";
		for (int i = (binario.length() - 1); i >= 0; i--) {
			bin += "" + binario.charAt(i);
		}

		binario = bin;
		return binario;

	}

	/**
	 * Metodo que executa a operação logica and na matriz da imagem
	 * 
	 * Tem como parametro a matriz da primeira imagem selecionada
	 * 
	 * @param matrizImagem1 Tem como parametro a matriz da segunda imagem
	 *                      selecionada
	 * @param matrizImagem2 Retorna a matriz operada
	 * @return
	 */

	public static int[][] andImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
		for (int i = 0; i < matrizImagemFinal.length; i++) {
			for (int j = 0; j < matrizImagemFinal.length; j++) {
				String binario = operacaoAndLogico(matrizImagem1[i][j], matrizImagem2[i][j]);
				matrizImagemFinal[i][j] = Integer.parseInt(binario, 2);

			}

		}

		matrizImagemFinal = normalizacao(matrizImagemFinal);
		return matrizImagemFinal;

	}

	/**
	 * Metodo que executa a operação logica or na matriz da imagem
	 * 
	 * Tem como parametro a matriz da primeira imagem selecionada
	 * 
	 * @param matrizImagem1 Tem como parametro a matriz da segunda imagem
	 *                      selecionada
	 * @param matrizImagem2 Retorna a matriz operada
	 * @return
	 */

	public static int[][] orImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
		for (int i = 0; i < matrizImagemFinal.length; i++) {
			for (int j = 0; j < matrizImagemFinal.length; j++) {
				String binario = OoperacaoOrLogico(matrizImagem1[i][j], matrizImagem2[i][j]);
				matrizImagemFinal[i][j] = Integer.parseInt(binario, 2);

			}

		}

		matrizImagemFinal = normalizacao(matrizImagemFinal);
		return matrizImagemFinal;

	}

	/**
	 * Metodo que executa a operação logica xor na matriz da imagem
	 * 
	 * Tem como parametro a matriz da primeira imagem selecionada
	 * 
	 * @param matrizImagem1 Tem como parametro a matriz da segunda imagem
	 *                      selecionada
	 * @param matrizImagem2 Retorna a matriz operada
	 * @return
	 */

	public static int[][] xorImagens(int[][] matrizImagem1, int[][] matrizImagem2) {
		int[][] matrizImagemFinal = new int[matrizImagem1.length][matrizImagem1.length];
		for (int i = 0; i < matrizImagemFinal.length; i++) {
			for (int j = 0; j < matrizImagemFinal.length; j++) {
				String binario = operacoesXorLogico(matrizImagem1[i][j], matrizImagem2[i][j]);
				matrizImagemFinal[i][j] = Integer.parseInt(binario, 2);

			}

		}

		matrizImagemFinal = normalizacao(matrizImagemFinal);
		return matrizImagemFinal;

	}

	/**
	 * Metodo que separa os bits (em binario) atraves da função charAt para ser
	 * feita a operação logicas xor Tem como parametro uma String X
	 * 
	 * @param x Tem como parametro uma String y
	 * @param y Retorna o valor em binario separado
	 * @return
	 */

	public static String operacoesXorLogico(int x, int y) {
		String binario1 = intBinario(x);
		String binario2 = intBinario(y);
		String binarioFinal = "";

		for (int k = 0; k < 8; k++) {
			if (((binario1.charAt(k) == '0') && (binario2.charAt(k) == '0'))
					|| ((binario1.charAt(k) == '1') && (binario2.charAt(k) == '1'))) {
				binarioFinal += "0";
			} else {
				binarioFinal += "1";
			}

		}

		return binarioFinal;
	}

	/**
	 * Metodo que separa os bits (em binario) atraves da função charAt para ser
	 * feita a operação logicas xor Tem como parametro uma String X
	 * 
	 * @param x Tem como parametro uma String y
	 * @param y Retorna o valor em binario separado
	 * @return
	 */

	public static String OoperacaoOrLogico(int x, int y) {
		String binario1 = intBinario(x);
		String binario2 = intBinario(y);
		String binarioFinal = "";

		for (int k = 0; k < 8; k++) {
			if ((binario1.charAt(k) == '0') && (binario2.charAt(k) == '0')) {
				binarioFinal += "0";
			} else {
				binarioFinal += "1";
			}

		}

		return binarioFinal;

	}

	/**
	 * Metodo que separa os bits (em binario) atraves da função charAt para ser
	 * feita a operação logicas xor Tem como parametro uma String X
	 * 
	 * @param x Tem como parametro uma String y
	 * @param y Retorna o valor em binario separado
	 * @return
	 */

	public static String operacaoAndLogico(int x, int y) {
		String binario1 = intBinario(x);
		String binario2 = intBinario(y);
		String binarioFinal = "";

		for (int k = 0; k < 8; k++) {
			if ((binario1.charAt(k) == '1') && (binario2.charAt(k) == '1')) {
				binarioFinal += "1";
			} else {
				binarioFinal += "0";
			}

		}

		return binarioFinal;

	}

	/**
	 * 
	 * @param matriz
	 * @return
	 */
	public static int[][] normalizacao(int[][] matriz) {
		int min = matriz[0][0];
		int max = matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (min > matriz[i][j]) {
					min = matriz[i][j];
				}

				if (max < matriz[i][j]) {
					max = matriz[i][j];
				}
			}
		}

		int[][] matrizFinal = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matrizFinal.length; i++) {
			for (int j = 0; j < matrizFinal[0].length; j++) {
				if (max == min) {
					matrizFinal[i][j] = max;
				} else {
					matrizFinal[i][j] = (int) Math.round((255 * (matriz[i][j] - min)) / (max - min));

				}
			}

		}

		return matrizFinal;
	}

}