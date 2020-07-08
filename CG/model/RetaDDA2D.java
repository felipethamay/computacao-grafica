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

import view.TelaPainel;
import view.TelaRetas;

public class RetaDDA2D {

	/**
	 * Método que executa o algoritmo DDA (Digital Diferential Analyser) Necessita
	 * como parâmetro dos pontos x e y da origem e do destino
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param cor
	 */
	public static void executaDDA(int x1, int y1, int x2, int y2, int cor[]) {

		DefaultTableModel modelo = (DefaultTableModel) TelaRetas.jTable1.getModel();
		modelo.setNumRows(0);
		double Length, Xinc, Yinc, x, y;
		Length = Math.abs(x2 - x1);
		if (Math.abs(y2 - y1) > Length) {
			Length = Math.abs(y2 - y1);
		}

		Xinc = Math.abs(x2 - x1) / Length;
		Yinc = Math.abs(y2 - y1) / Length;

		x = x1;
		y = y1;

		if ((Math.abs(x2 - x1)) >= (Math.abs(y2 - y1))) {

			if ((x1 > x2) && (y1 > y2)) {

				while (x >= x2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x - Xinc;
					y = y - Yinc;

				}

			} else if ((x1 < x2) && (y1 > y2)) {

				while (x <= x2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x + Xinc;
					y = y - Yinc;

				}

			} else if ((x1 > x2) && (y < y2)) { // 2

				while (x >= x2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x - Xinc;
					y = y + Yinc;

				}

			} else if (x > x2) {

				while (x >= x2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x - Xinc;
					y = y + Yinc;

				}

			} else {

				while (x <= x2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x + Xinc;
					y = y + Yinc;

				}

			}

		} else {

			if ((x1 > x2) && (y1 < y2)) {

				while (y <= y2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x - Xinc;
					y = y + Yinc;

				}

			} else if ((x1 > x2) && (y1 > y2)) {

				while (y >= y2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x - Xinc;
					y = y - Yinc;

				}

			} else if ((x1 < x2) && (y1 > y2)) {

				while (y >= y2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x + Xinc;
					y = y - Yinc;

				}

			} else if (y1 > y2) {

				while (y >= y2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x + Xinc;
					y = y - Yinc;

				}

			} else {

				while (y <= y2) {

					int coorX = (int) (Math.round(x));
					int coorY = (int) (Math.round(y));

					int coorA = TransformacaoDispositivo2D.transformaPontosX(coorX);
					int coorB = TransformacaoDispositivo2D.transformaPontosY(coorY);

					modelo.addRow(new Object[] { "", coorX, coorY });
					TelaPainel.setPixel(coorA, coorB, cor);

					x = x + Xinc;
					y = y + Yinc;

				}

			}

		}

	}

}