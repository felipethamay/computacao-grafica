package model;

/**
 * Universidade Estadual da Paraiba Departamento de Computacao Curso de
 * Licenciatura Plena em Computacao Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno Equipe: Arthur Felipe Thamay Medeiros, Jefferson
 * Felipe Silva de Lima, Thalles Gutembergh dos Santos 2012.2
 */

public class OperacoesFiltros {

	/**
	 * Função negativo Adiciona na nova matriz imagem o complemento do seu valor
	 * para cada posicao Tem como parametro a matriz da imagem
	 * 
	 * @param matriz Retorna a matriz aplicada o filtro
	 * @return
	 */

	public static int[][] negativo(int[][] matriz) {
		int[][] matrizImagem = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matrizImagem.length; i++) {
			for (int j = 0; j < matrizImagem[0].length; j++) {
				matrizImagem[i][j] = 255 - matriz[i][j];

			}

		}

		return matrizImagem;

	}

	/**
	 * Função Correção Gamma Elimina o excesso de claridade da imagem Tem como
	 * parametro a matriz da imagem
	 * 
	 * @param matriz Tem como parametro o valor de "A" passado pelo usuario
	 * @param a      Retorna a matriz aplicada o filtro
	 * @return
	 */
	public static int[][] gamma(int[][] matriz, double a) {
		int[][] matrizImagem = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matrizImagem.length; i++) {
			for (int j = 0; j < matrizImagem[0].length; j++) {
				matrizImagem[i][j] = (int) Math.pow(matriz[i][j], a);
			}
		}
		return matrizImagem;

	}

	/**
	 * Função logaritmo Faz o mapeamento logarítmico de valores de níveis de cinza
	 * para aumentar o contraste Tem como parametro a matriz da imagem
	 * 
	 * @param matriz Tem como parametro o valor de "A" passado pelo usuario
	 * @param a      Retorna a matriz aplicada o filtro
	 * @return
	 */
	public static int[][] logaritmo(int[][] matriz, int a) {
		int[][] matrizImagem = new int[matriz.length][matriz[0].length];
		for (int i = 0; i < matrizImagem.length; i++) {
			for (int j = 0; j < matrizImagem[0].length; j++) {
				int nivelCinza = a * (int) (Math.log(matriz[i][j] + 1));
				if (nivelCinza < 0) {
					nivelCinza = 0;

				}
				if (nivelCinza > 255) {
					nivelCinza = 255;
				}
				matrizImagem[i][j] = nivelCinza;

			}

		}

		return matrizImagem;

	}

	/**
	 * Metodo que calcula a convolução das matrizes passa alta, prewitt, robert e
	 * sobel Recebe uma imagem e o tipo de filtro a ser executado Tem como parametro
	 * a matriz da imagem
	 * 
	 * @param matriz Tem como parametro o filtro a ser aplicado
	 * @param filtro Retorna a matriz da imagem convoluida
	 * @return
	 */
	public static int[][] convolucaoMatrizes(int[][] matriz, int[][] filtro) {
		int[][] matrizBorda = new int[matriz.length + 2][matriz[0].length + 2];
		for (int i = 0; i < matrizBorda.length; i++) {
			for (int j = 0; j < matrizBorda[0].length; j++) {
				if (i == 0) {
					matrizBorda[i][j] = 0;
				} else if (i == (matrizBorda.length - 1)) {
					matrizBorda[i][j] = 0;
				} else if (j == 0) {
					matrizBorda[i][j] = 0;
				} else if (j == (matrizBorda[0].length - 1)) {
					matrizBorda[i][j] = 0;
				} else {
					matrizBorda[i][j] = matriz[i - 1][j - 1];
				}

			}
		}

		int[][] matrizImagem = new int[matriz.length][matriz[0].length];

		int soma = 0;
		for (int i = 0; i < (matrizBorda.length - 2); i++) {

			for (int j = 0; j < (matrizBorda[0].length - 2); j++) {

				soma += matrizBorda[i][j] * filtro[0][0];
				soma += matrizBorda[i][j + 1] * filtro[0][1];
				soma += matrizBorda[i][j + 2] * filtro[0][2];
				soma += matrizBorda[i + 1][j] * filtro[1][0];
				soma += matrizBorda[i + 1][j + 1] * filtro[1][1];
				soma += matrizBorda[i + 1][j + 2] * filtro[1][2];
				soma += matrizBorda[i + 2][j] * filtro[2][0];
				soma += matrizBorda[i + 2][j + 1] * filtro[2][1];
				soma += matrizBorda[i + 2][j + 2] * filtro[2][2];

				// reenvia o valor absoluto (valor positivo) da soma.
				// Isto é, este método elemina o símbolo negativo de um número.
				matrizImagem[i][j] = Math.abs(soma);
				soma = 0;

			}
		}
		return matrizImagem;
	}

	/**
	 * Metodo que calcula a convolução das matrizes alto reforço e media Tem como
	 * parametro a matriz da imagem
	 * 
	 * @param matriz Tem como parametro o filtro a ser aplicado
	 * @param filtro Retorna a matriz da imagem convoluida
	 * @return
	 */

	public static int[][] convolucao(int[][] matriz, double[][] filtro) {
		int[][] matrizBorda = new int[matriz.length + 2][matriz[0].length + 2];
		for (int i = 0; i < matrizBorda.length; i++) {
			for (int j = 0; j < matrizBorda[0].length; j++) {
				if (i == 0) {
					matrizBorda[i][j] = 0;
				} else if (i == (matrizBorda.length - 1)) {
					matrizBorda[i][j] = 0;
				} else if (j == 0) {
					matrizBorda[i][j] = 0;

				} else if (j == (matrizBorda[0].length - 1)) {
					matrizBorda[i][j] = 0;
				} else {
					matrizBorda[i][j] = matriz[i - 1][j - 1];
				}

			}

		}

		int[][] matrizImagem = new int[matriz.length][matriz[0].length];
		double soma = 0;
		for (int i = 0; i < (matrizBorda.length - 2); i++) {

			for (int j = 0; j < (matrizBorda[0].length - 2); j++) {
				soma += matrizBorda[i][j] * filtro[0][0];
				soma += matrizBorda[i][j + 1] * filtro[0][1];
				soma += matrizBorda[i][j + 2] * filtro[0][2];
				soma += matrizBorda[i + 1][j] * filtro[1][0];
				soma += matrizBorda[i + 1][j + 1] * filtro[1][1];
				soma += matrizBorda[i + 1][j + 2] * filtro[1][2];
				soma += matrizBorda[i + 2][j] * filtro[2][0];
				soma += matrizBorda[i + 2][j + 1] * filtro[2][1];
				soma += matrizBorda[i + 2][j + 2] * filtro[2][2];

				if (soma > 255) {
					soma = 255;

				}
				if (soma < 0) {
					soma = 0;
				}

				matrizImagem[i][j] = (int) Math.round(soma);
				soma = 0;

			}
		}

		return matrizImagem;

	}

	/**
	 * Função que calcula a convolução do filtro da mediana Tem como parametro a
	 * matriz da imagem
	 * 
	 * @param matriz Retorna a matriz da imagem convoluida
	 * @return
	 */

	public static int[][] convolucaoMediana(int[][] matriz) {
		int[][] matrizBorda = new int[matriz.length + 2][matriz[0].length + 2];
		for (int i = 0; i < matrizBorda.length; i++) {
			for (int j = 0; j < matrizBorda[0].length; j++) {
				if (i == 0) {
					matrizBorda[i][j] = 0;
				} else if (i == (matrizBorda.length - 1)) {
					matrizBorda[i][j] = 0;
				} else if (j == 0) {
					matrizBorda[i][j] = 0;
				} else if (j == (matrizBorda[0].length - 1)) {
					matrizBorda[i][j] = 0;
				} else {
					matrizBorda[i][j] = matriz[i - 1][j - 1];
				}

			}

		}

		int[][] matrizImagem = new int[matriz.length][matriz[0].length];
		int[] ordenaTonsdeCinza = new int[9];

		for (int i = 0; i < (matrizBorda.length - 2); i++) {

			for (int j = 0; j < (matrizBorda[0].length - 2); j++) {

				ordenaTonsdeCinza[0] = matrizBorda[i][j];
				ordenaTonsdeCinza[1] = matrizBorda[i][j + 1];
				ordenaTonsdeCinza[2] = matrizBorda[i][j + 2];
				ordenaTonsdeCinza[3] = matrizBorda[i + 1][j];
				ordenaTonsdeCinza[4] = matrizBorda[i + 1][j + 1];
				ordenaTonsdeCinza[5] = matrizBorda[i + 1][j + 2];
				ordenaTonsdeCinza[6] = matrizBorda[i + 2][j];
				ordenaTonsdeCinza[7] = matrizBorda[i + 2][j + 1];
				ordenaTonsdeCinza[8] = matrizBorda[i + 2][j + 2];
				ordenaBolha(ordenaTonsdeCinza);
				matrizImagem[i][j] = ordenaTonsdeCinza[4];
				for (int j2 = 0; j2 < ordenaTonsdeCinza.length; j2++) {

					ordenaTonsdeCinza[j2] = 0;

				}

			}
		}

		return matrizImagem;

	}

	/**
	 * Metodo de ordenação em bolha (BubbleSort) utilizado na matriz de convolução
	 * do filtro da mediana para ordenar em ordem crescente os valores da matriz
	 * 
	 * Tem como parametro o vetor a ser ordenado
	 * 
	 * @param vetor
	 */
	public static void ordenaBolha(int[] vetor) {
		boolean houveTroca = true;
		while (houveTroca) {
			houveTroca = false;
			for (int i = 0; i < (vetor.length) - 1; i++) {
				if (vetor[i] > vetor[i + 1]) {
					int variavelAuxiliar = vetor[i + 1];
					vetor[i + 1] = vetor[i];
					vetor[i] = variavelAuxiliar;
					houveTroca = true;
				}
			}
		}
	}

}