package model;

/**
 * Universidade Estadual da Paraiba Departamento de Computacao Curso de
 * Licenciatura Plena em Computacao Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno Equipe: Arthur Felipe Thamay Medeiros, Jefferson
 * Felipe Silva de Lima, Thalles Gutembergh dos Santos 2012.2
 */

public class Transformacoes2D {

	public static int[][] multiplicaMatriz(double[][] matrizA, int[][] matrizB) {
		int[][] matrizC = new int[matrizA.length][matrizB[0].length];
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizB[0].length; j++) {
				matrizC[i][j] = 0;
				for (int l = 0; l < matrizA[0].length; l++) {
					matrizC[i][j] = matrizC[i][j] + (int) Math.round(matrizA[i][l] * matrizB[l][j]);

				}
			}
		}

		return matrizC;

	}

	/**
	 * Matriz utilizada para translação de objeto de acordo com os parâmetros abaixo
	 * 
	 * @param Tx
	 * @param Ty
	 * @return
	 */
	public static double[][] translacao(int Tx, int Ty) {
		double[][] matriz = new double[3][3];

		matriz[0][0] = 1;
		matriz[0][1] = 0;
		matriz[0][2] = Tx;
		matriz[1][0] = 0;
		matriz[1][1] = 1;
		matriz[1][2] = Ty;
		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;

	}

	/**
	 * Matriz utilizada para reflexão de objeto em torno da reta (x ou y) de acordo
	 * com os parâmetros abaixo
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static double[][] reflexao(int x, int y) {
		double[][] matriz = new double[3][3];

		matriz[0][0] = x;
		matriz[0][1] = 0;
		matriz[0][2] = 0;
		matriz[1][0] = 0;
		matriz[1][1] = y;
		matriz[1][2] = 0;
		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;

	}

	/**
	 * Matriz utilizada para Rotação de objeto de acordo com o ângulo inserido pelo
	 * usuário
	 * 
	 * @param angulo
	 * @return
	 */
	public static double[][] rotacao(int angulo) {
		double radiano = ((1.570796327) * angulo) / 90;
		double[][] matriz = new double[3][3];

		matriz[0][0] = Math.cos(radiano);
		matriz[0][1] = -(Math.sin(radiano));
		matriz[0][2] = 0;
		matriz[1][0] = Math.sin(radiano);
		matriz[1][1] = Math.cos(radiano);
		matriz[1][2] = 0;
		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;

	}

	/**
	 * Matriz utilizada para rotação de objeto em torno da reta de acordo com os
	 * parâmetros abaixo
	 * 
	 * @param cos
	 * @param sen
	 * @return
	 */
	public static double[][] rotacaonaReta(double cos, double sen) {
		double[][] matriz = new double[3][3];

		matriz[0][0] = cos;
		matriz[0][1] = -sen;
		matriz[0][2] = 0;
		matriz[1][0] = sen;
		matriz[1][1] = cos;
		matriz[1][2] = 0;
		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;

	}

	/**
	 * Matriz utilizada para mudança de escala de objeto de acordo com os parâmetros
	 * abaixo
	 * 
	 * @param Sx
	 * @param Sy
	 * @return
	 */
	public static double[][] escala(double Sx, double Sy) {
		double[][] matriz = new double[3][3];

		matriz[0][0] = Sx;
		matriz[0][1] = 0;
		matriz[0][2] = 0;
		matriz[1][0] = 0;
		matriz[1][1] = Sy;
		matriz[1][2] = 0;
		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;

	}

	/**
	 * Matriz utilizada para cisalhamento de objeto de acordo com os parâmetros
	 * abaixo
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] cisalhamento(double a, double b) {
		double[][] matriz = new double[3][3];

		matriz[0][0] = 1;
		matriz[0][1] = a;
		matriz[0][2] = 0;
		matriz[1][0] = b;
		matriz[1][1] = 1;
		matriz[1][2] = 0;
		matriz[2][0] = 0;
		matriz[2][1] = 0;
		matriz[2][2] = 1;

		return matriz;

	}

	/**
	 * Método responsável pela multiplicação de matrizes
	 * 
	 * @param matrizA
	 * @param matrizB
	 * @return
	 */

	public static double[][] multiplicaMatrizTrans(double[][] matrizA, double[][] matrizB) {
		double[][] matrizC = new double[matrizA.length][matrizB[0].length];
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizB[0].length; j++) {
				matrizC[i][j] = 0;
				for (int l = 0; l < matrizA[0].length; l++) {
					matrizC[i][j] = matrizC[i][j] + matrizA[i][l] * matrizB[l][j];

				}
			}
		}

		return matrizC;

	}

}
