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

import javax.swing.table.DefaultTableModel;

import view.TelaCircunferencia;
import view.TelaPainel;

public class Circunferencia2D {

	/**
	 * Simetrica de ordem 8 Desenha a circunferencia nos 8 oitantes do plano
	 * 
	 * Tem como parametro x
	 * 
	 * @param x     Tem como parametro x
	 * @param y     Tem como parametro centX
	 * @param centX Tem como parametro centY
	 * @param centY
	 */
	public static void desenhaOitoPontos(int x, int y, int centX, int centY) {

		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 0;
		cor[2] = 255;

		int coordX = TransformacaoDispositivo2D.transformaPontosX((x + centX));
		int coordY = TransformacaoDispositivo2D.transformaPontosY((y + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX((y + centX));
		coordY = TransformacaoDispositivo2D.transformaPontosY((x + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX((y + centX));
		coordY = TransformacaoDispositivo2D.transformaPontosY((-x + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX((x + centX));
		coordY = TransformacaoDispositivo2D.transformaPontosY((-y + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX((-x + centX));
		coordY = TransformacaoDispositivo2D.transformaPontosY((-y + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX((-y + centX));
		coordY = TransformacaoDispositivo2D.transformaPontosY((-x + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX((-y + centX));
		coordY = TransformacaoDispositivo2D.transformaPontosY((x + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX((-x + centX));
		coordY = TransformacaoDispositivo2D.transformaPontosY((y + centY));
		TelaPainel.setPixel(coordX, coordY, cor);

	}

	/**
	 * Calcula atraves da equacao explicita da circunferencia
	 * 
	 * Tem como parametro o raio
	 * 
	 * @param raio  Tem como parametro xcent
	 * @param xcent Tem como parametro ycent
	 * @param ycent
	 */
	public static void equacaoExplicitadaCircuferencia(int raio, int xcent, int ycent) {

		DefaultTableModel modelo = (DefaultTableModel) TelaCircunferencia.jTable1.getModel();
		modelo.setNumRows(0);

		int x = 0;
		int y;
		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 0;
		cor[2] = 255;

		int centx = TransformacaoDispositivo2D.transformaPontosX(xcent);
		int centy = TransformacaoDispositivo2D.transformaPontosY(ycent);
		TelaPainel.setPixel(centx, centy, cor);

		while (x <= raio) {

			y = (int) (Math.sqrt((raio * raio) - (x * x)));

			modelo.addRow(new Object[] { "", x + xcent, y + ycent });

			int coordX = TransformacaoDispositivo2D.transformaPontosX((x + xcent));
			int coordY = TransformacaoDispositivo2D.transformaPontosY((y + ycent));
			TelaPainel.setPixel(coordX, coordY, cor);

			coordX = TransformacaoDispositivo2D.transformaPontosX((x + xcent));
			coordY = TransformacaoDispositivo2D.transformaPontosY((-y + ycent));
			TelaPainel.setPixel(coordX, coordY, cor);

			coordX = TransformacaoDispositivo2D.transformaPontosX((-x + xcent));
			coordY = TransformacaoDispositivo2D.transformaPontosY((-y + ycent));
			TelaPainel.setPixel(coordX, coordY, cor);

			coordX = TransformacaoDispositivo2D.transformaPontosX((-x + xcent));
			coordY = TransformacaoDispositivo2D.transformaPontosY((y + ycent));
			TelaPainel.setPixel(coordX, coordY, cor);

			x = x + 1;

		}

	}

	/**
	 * Calcula atraves do metodo trigonometrico
	 * 
	 * Tem como parametro o raio
	 * 
	 * @param raio  Tem como parametro xcent
	 * @param xcent Tem como parametro ycent
	 * @param ycent
	 */
	public static void metodoTrigonometrico(int raio, int xcent, int ycent) {

		DefaultTableModel modelo = (DefaultTableModel) TelaCircunferencia.jTable1.getModel();
		modelo.setNumRows(0);

		int angulo = 0;
		int x, y;

		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 0;
		cor[2] = 255;
		int centx = TransformacaoDispositivo2D.transformaPontosX(xcent);
		int centy = TransformacaoDispositivo2D.transformaPontosY(ycent);
		TelaPainel.setPixel(centx, centy, cor);

		while (angulo <= 360) {

			x = (int) (raio * (Math.cos(angulo)));
			y = (int) (raio * (Math.sin(angulo)));
			desenhaOitoPontos(x, y, xcent, ycent);

			modelo.addRow(new Object[] { "", x + xcent, y + ycent });

			angulo = angulo + 1;

		}

	}

	/**
	 * Calcula atraves do ponto medio
	 * 
	 * Tem como parametro o raio
	 * 
	 * @param raio  Tem como parametro xcent
	 * @param xcent Tem como parametro ycent
	 * @param ycent
	 */
	public static void pontoMedio(int raio, int xcent, int ycent) {

		DefaultTableModel modelo = (DefaultTableModel) TelaCircunferencia.jTable1.getModel();
		modelo.setNumRows(0);

		int x = 0;
		int y = raio;
		int d = (1 - raio);

		desenhaOitoPontos(x, y, xcent, ycent);

		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 0;
		cor[2] = 255;
		int centx = TransformacaoDispositivo2D.transformaPontosX(xcent);
		int centy = TransformacaoDispositivo2D.transformaPontosY(ycent);
		TelaPainel.setPixel(centx, centy, cor);

		while (y > x) {
			modelo.addRow(new Object[] { d, x, y });
			if (d < 0) {
				d += (2 * x + 3);
			} else {
				d += 2 * (x - y) + 5;
				y = y - 1;

			}
			x = x + 1;

			desenhaOitoPontos(x, y, xcent, ycent);

		}

	}

}