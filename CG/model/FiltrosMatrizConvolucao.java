package model;

/**
 * Universidade Estadual da Paraiba Departamento de Computacao Curso de
 * Licenciatura Plena em Computacao Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno Equipe: Arthur Felipe Thamay Medeiros, Jefferson
 * Felipe Silva de Lima, Thalles Gutembergh dos Santos 2012.2
 */

public class FiltrosMatrizConvolucao {

	/**
	 * Matriz de convolução do filtro passa alta
	 *
	 * @return
	 */
	public static int[][] passaAlta() {
		int[][] passaAlta = new int[3][3];
		int fator = -1;

		passaAlta[0][0] = fator;
		passaAlta[0][1] = fator;
		passaAlta[0][2] = fator;
		passaAlta[1][0] = fator;
		passaAlta[1][1] = 8;
		passaAlta[1][2] = fator;
		passaAlta[2][0] = fator;
		passaAlta[2][1] = fator;
		passaAlta[2][2] = fator;

		return passaAlta;
	}

	/**
	 * Matriz de convolução do filtro robert em x
	 * 
	 * @return
	 */
	public static int[][] robertX() {
		int[][] robertX = new int[3][3];

		robertX[0][0] = 0;
		robertX[0][1] = 0;
		robertX[0][2] = 0;
		robertX[1][0] = 0;
		robertX[1][1] = 1;
		robertX[1][2] = 0;
		robertX[2][0] = 0;
		robertX[2][1] = -1;
		robertX[2][2] = 0;

		return robertX;
	}

	/**
	 * Matriz de convolução do filtro Robert em y
	 * 
	 * @return
	 */
	public static int[][] robertY() {
		int[][] robertY = new int[3][3];

		robertY[0][0] = 0;
		robertY[0][1] = 0;
		robertY[0][2] = 0;
		robertY[1][0] = 0;
		robertY[1][1] = 1;
		robertY[1][2] = -1;
		robertY[2][0] = 0;
		robertY[2][1] = 0;
		robertY[2][2] = 0;

		return robertY;
	}

	/**
	 * Matriz de convolução do filtro Robert cruzado em X
	 * 
	 * @return
	 */
	public static int[][] robertCruzadoX() {
		int[][] robertCruzadoX = new int[3][3];

		robertCruzadoX[0][0] = 0;
		robertCruzadoX[0][1] = 0;
		robertCruzadoX[0][2] = 0;
		robertCruzadoX[1][0] = 0;
		robertCruzadoX[1][1] = 1;
		robertCruzadoX[1][2] = 0;
		robertCruzadoX[2][0] = 0;
		robertCruzadoX[2][1] = 0;
		robertCruzadoX[2][2] = -1;

		return robertCruzadoX;
	}

	/**
	 * Matriz de convolução do filtro Robert cruzado em Y
	 * 
	 * @return
	 */
	public static int[][] robertCruzadoY() {

		int[][] robertCruzadoY = new int[3][3];

		robertCruzadoY[0][0] = 0;
		robertCruzadoY[0][1] = 0;
		robertCruzadoY[0][2] = 0;
		robertCruzadoY[1][0] = 0;
		robertCruzadoY[1][1] = 0;
		robertCruzadoY[1][2] = 1;
		robertCruzadoY[2][0] = 0;
		robertCruzadoY[2][1] = -1;
		robertCruzadoY[2][2] = 0;

		return robertCruzadoY;
	}

	/**
	 * Matriz de convolução do filtro Prewitt em x
	 * 
	 * @return
	 */
	public static int[][] prewittX() {
		int[][] prewittX = new int[3][3];

		prewittX[0][0] = -1;
		prewittX[0][1] = -1;
		prewittX[0][2] = -1;
		prewittX[1][0] = 0;
		prewittX[1][1] = 0;
		prewittX[1][2] = 0;
		prewittX[2][0] = 1;
		prewittX[2][1] = 1;
		prewittX[2][2] = 1;

		return prewittX;
	}

	/**
	 * Matriz de convolução do filtro Prewitt em y
	 * 
	 * @return
	 */
	public static int[][] prewittY() {
		int[][] prewittY = new int[3][3];

		prewittY[0][0] = -1;
		prewittY[0][1] = 0;
		prewittY[0][2] = 1;
		prewittY[1][0] = -1;
		prewittY[1][1] = 0;
		prewittY[1][2] = 1;
		prewittY[2][0] = -1;
		prewittY[2][1] = 0;
		prewittY[2][2] = 1;

		return prewittY;
	}

	/**
	 * Matriz de convolução do filtro Alto reforco
	 * 
	 * Tem como parametro um valor A ser inserido. O A inserido, fará parte da
	 * fórmula w = (9*a)-1 de acordo com a regra.
	 * 
	 * @param a
	 * @return
	 */
	public static double[][] altoreforco(double a) {
		double w = (double) ((9 * a) - 1);
		System.out.println(w);
		double[][] altoReforco = new double[3][3];

		altoReforco[0][0] = -1;
		altoReforco[0][1] = -1;
		altoReforco[0][2] = -1;
		altoReforco[1][0] = -1;
		altoReforco[1][1] = w;
		altoReforco[1][2] = -1;
		altoReforco[2][0] = -1;
		altoReforco[2][1] = -1;
		altoReforco[2][2] = -1;

		return altoReforco;
	}

	/**
	 * Matriz de convolução do filtro sobel em x
	 * 
	 * @return
	 */
	public static int[][] sobelX() {
		int[][] sobelX = new int[3][3];

		sobelX[0][0] = -1;
		sobelX[0][1] = -2;
		sobelX[0][2] = -1;
		sobelX[1][0] = 0;
		sobelX[1][1] = 0;
		sobelX[1][2] = 0;
		sobelX[2][0] = 1;
		sobelX[2][1] = 2;
		sobelX[2][2] = 1;

		return sobelX;
	}

	/**
	 * Matriz de convolução do filtro sobel em y
	 * 
	 * @return
	 */
	public static int[][] sobelY() {
		int[][] sobelY = new int[3][3];

		sobelY[0][0] = -1;
		sobelY[0][1] = 0;
		sobelY[0][2] = 1;
		sobelY[1][0] = -2;
		sobelY[1][1] = 0;
		sobelY[1][2] = 2;
		sobelY[2][0] = -1;
		sobelY[2][1] = 0;
		sobelY[2][2] = 1;

		return sobelY;
	}

	/**
	 * Matriz de convolução do filtro da media
	 * 
	 * @return
	 */
	public static double[][] media() {
		double[][] media = new double[3][3];

		double fator = 0.1;

		media[0][0] = fator;
		media[0][1] = fator;
		media[0][2] = fator;
		media[1][0] = fator;
		media[1][1] = fator;
		media[1][2] = fator;
		media[2][0] = fator;
		media[2][1] = fator;
		media[2][2] = fator;

		return media;
	}

}