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

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import exceptions.FormatoImagemException;

public class LerArquivo {

	public int[][] pixels;
	public int maxValue;
	public int largura;
	public int altura;

	/**
	 * Construtor Tem como parametro a largura da imagem
	 * 
	 * @param largura  Tem como parametro a altura da imagem
	 * @param altura   Tem como parametro o nivel maximo de cinza
	 * @param maxValue Tem como parametro a quantidade de pixels no array de imagem
	 * @param pixels
	 */
	public LerArquivo(int largura, int altura, int maxValue, int[][] pixels) {
		this.setLargura(largura);
		this.setAltura(altura);
		this.setMaxValue(maxValue);
		this.setPixels(pixels);
	}

	/**
	 * Tem como parametro o nome do arquivo
	 * 
	 * @param nomeDoArquivo Levanta a excecao quando deseja ler um arquivo que nao
	 *                      existe ou um arquivo que tem um nome inv√°lido
	 * @throws IOException
	 */
	public LerArquivo(String nomeDoArquivo) throws IOException {
		BufferedReader imgArq = new BufferedReader(new FileReader(nomeDoArquivo));

		String head = imgArq.readLine();
		if (!head.equals("P2")) {
			System.out.println("O arquivo n√£o e PGM!");
		}
		// Ignorando comentarios
		String info = "";
		do {
			info = imgArq.readLine();
		} while (info.startsWith("#"));

		// le largura e altura da imagem
		StringTokenizer st = new StringTokenizer(info, " ");

		largura = Integer.parseInt(st.nextToken());
		altura = Integer.parseInt(st.nextToken());

		// pega o nivel maximo de cinza
		maxValue = Integer.parseInt(imgArq.readLine());

		pixels = new int[largura][altura];

		String dados;
		for (int i = 0; i < altura; i++) {
			dados = imgArq.readLine();
			pixels[i] = recorta(dados);
		}
		imgArq.close();
	}

	/**
	 * Verifica se a imagem È no formato PGM Tem como parametro o arquivo
	 * selecionado
	 * 
	 * @param arquivo ExceÁ„o levantada caso a imagem n„o seja no formato PGM
	 * @throws FormatoImagemException Levanta a excecao quando deseja ler um arquivo
	 *                                que nao existe ou um arquivo que tem um nome
	 *                                inv·lido
	 * @throws IOException
	 */
	public static void verificaImagem(String arquivo) throws FormatoImagemException, IOException {
		BufferedReader arq = new BufferedReader(new FileReader(arquivo));
		String header = arq.readLine();
		if (!header.equals("P2")) {
			try {
				throw new Exception("O arquivo n„o È PGM!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ObtÈm a quantidade de pixels por linha
	 * 
	 * Tem como parametro o arquivo selecionado
	 * 
	 * @param arquivo Retorna a quantidade de pixels por linha
	 * @return Levanta a excecao quando deseja ler um arquivo que nao existe ou um
	 *         arquivo que tem um nome inv√°lido
	 * @throws IOException
	 */
	public static int largura(String arquivo) throws IOException {

		BufferedReader arq = new BufferedReader(new FileReader(arquivo));
		@SuppressWarnings("unused")
		String primeiralinha = arq.readLine();
		String info = " ";
		do {
			info = arq.readLine();
		} while (info.charAt(0) == '#');
		StringTokenizer st = new StringTokenizer(info, " ");
		int largura = Integer.parseInt(st.nextToken());

		return largura;

	}

	/**
	 * ObtÈm a quantidade de pixels por coluna ou a quantidade de linhas Tem como
	 * parametro o arquivo selecionado
	 * 
	 * @param arquivo Retorna a quantidade de pixels por coluna
	 * @return Levanta a excecao quando deseja ler um arquivo que nao existe ou um
	 *         arquivo que tem um nome inv√°lido
	 * @throws IOException
	 */

	public static int altura(String arquivo) throws IOException {
		BufferedReader arq = new BufferedReader(new FileReader(arquivo));
		@SuppressWarnings("unused")
		String primeiralinha = arq.readLine();
		String info = " ";
		do {
			info = arq.readLine();
		} while (info.charAt(0) == '#');
		StringTokenizer st = new StringTokenizer(info, " ");
		st.nextToken();
		int altura = Integer.parseInt(st.nextToken());

		return altura;

	}

	/**
	 * Tem como parametro o arquivo selecionado
	 * 
	 * @param arquivo Tem como parametro a quantidade de pixels por linha
	 * @param largura Tem como parametro a quantidade de pixels por coluna
	 * @param altura  Retorna a matriz de pixels da imagem organizada em linhas e
	 *                colunas
	 * @return Levanta a excecao quando deseja ler um arquivo que nao existe ou um
	 *         arquivo que tem um nome inv·lido
	 * @throws IOException
	 */

	public static int[][] pixels(String arquivo, int largura, int altura) throws IOException {
		int[][] pixels = new int[largura][altura];
		BufferedReader arq = new BufferedReader(new FileReader(arquivo));
		@SuppressWarnings("unused")
		String primeiralinha = arq.readLine();
		String info = " ";
		do {
			info = arq.readLine();
		} while (info.charAt(0) == '#');
		info = arq.readLine();

		for (int i = 0; i < largura; i++) {
			info = arq.readLine();
			StringTokenizer st1 = new StringTokenizer(info, " ");
			for (int j = 0; j < altura; j++) {
				pixels[i][j] = Integer.parseInt(st1.nextToken());
			}
		}

		return pixels;

	}

	/**
	 * Tem como parametro uma string de entrada passada pelo usuario
	 * 
	 * @param entrada
	 * @return
	 */

	private int[] recorta(String entrada) {
		entrada += " ";
		int aux = 0;
		int[] array = new int[largura];
		int index = 0;
		for (int i = 0; i < entrada.length(); i++) {
			if (entrada.substring(i, i + 1).equals(" ")) {
				int valor = Integer.parseInt(entrada.substring(aux, i));
				aux = i + 1;
				array[index] = valor;
				index++;
			}
		}
		return array;
	}

	/**
	 * Retorna a imagem criada
	 * 
	 * @return
	 */
	public BufferedImage criar() {
		BufferedImage image = new BufferedImage(altura, largura, BufferedImage.TYPE_USHORT_GRAY);
		WritableRaster raster = image.getRaster();

		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				raster.setSample(i, j, 0, getPixels()[j][i] * 255);
			}
		}
		return image;

	}

	// Getters and setters
	public int getLargura() {
		return largura;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int[][] getPixels() {
		return pixels;
	}

	public void setPixels(int[][] pixels) {
		this.pixels = pixels;
	}

}