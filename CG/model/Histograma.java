package model;

/**
 * Universidade Estadual da Paraiba Departamento de Computacao Curso de
 * Licenciatura Plena em Computacao Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno Equipe: Arthur Felipe Thamay Medeiros, Jefferson
 * Felipe Silva de Lima, Thalles Gutembergh dos Santos 2012.2
 */

public class Histograma {

	/**
	 * Recebe a imagem
	 * 
	 * @param imagem
	 * @return
	 */
	public static int[][] equalizaImagem(int[][] imagem) {

		int[][] imagemFinal = new int[imagem.length][imagem[0].length];
		double quantidade = 0;
		double[] frequenciaAcumuladaCor = new double[256];
		double[] probabilidadeK = new double[256];
		int[] sk = new int[256];

		/**
		 * conta as frequencias de cada pixel na imagem e guarda em um array frequencia
		 * Acumulada
		 */
		for (int i = 0; i < frequenciaAcumuladaCor.length; i++) {
			for (int j = 0; j < imagem.length; j++) {
				for (int l = 0; l < imagem[0].length; l++) {
					if (i == imagem[j][l]) {
						quantidade += 1;
					}

				}
			}
			frequenciaAcumuladaCor[i] = quantidade;
		}

		/**
		 * calcula a probabilidade de cada pixel k
		 */
		for (int i = 0; i < probabilidadeK.length; i++) {
			probabilidadeK[i] = frequenciaAcumuladaCor[i] / (imagem.length * imagem[0].length);

		}

		/**
		 * calcula o mapeamento de cada nivel de cinza
		 */
		for (int i = 0; i < sk.length; i++) {
			sk[i] = (int) Math.round(probabilidadeK[i] * 255);

		}

		/**
		 * distribui o mapeamento para a imagem
		 */
		for (int a = 0; a < sk.length; a++) {
			for (int i = 0; i < imagem.length; i++) {
				for (int j = 0; j < imagem[0].length; j++) {
					if (a == imagem[i][j]) {
						imagemFinal[i][j] = sk[a];

					}

				}

			}
		}

		return imagemFinal;

	}
}