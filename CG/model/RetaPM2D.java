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

public class RetaPM2D {

	/**
	 * Executa o algoritmo do Ponto Médio
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param cor
	 */

	public static void executaPM(int x1, int y1, int x2, int y2, int cor[]) {

		DefaultTableModel modelo = (DefaultTableModel) TelaRetas.jTable1.getModel();
		modelo.setNumRows(0);
		int dx, dy, incE, incNE, d, x, y;

		dx = Math.abs(x2 - x1);
		dy = Math.abs(y2 - y1);

		x = x1;
		y = y1;

		int coorA = TransformacaoDispositivo2D.transformaPontosX(x);
		int coorB = TransformacaoDispositivo2D.transformaPontosY(y);

		TelaPainel.setPixel(coorA, coorB, cor);

		if ((x1 < x2) && (y1 <= y2)) { // 1Quadrante

			if (dx >= dy) {

				d = 2 * dy - dx;
				incE = 2 * dy;
				incNE = 2 * (dy - dx);

				modelo.addRow(new Object[] { d, x, y });

				while (x < x2) {
					if (d <= 0) {
						d = d + incE;
						x = x + 1;

					} else {
						d = d + incNE;
						x = x + 1;
						y = y + 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			} else if (dx < dy) {

				d = dy - 2 * dx;
				incE = 2 * (dy - dx);
				incNE = 2 * (-dx);

				modelo.addRow(new Object[] { d, x, y });

				while (y < y2) {

					if (d < 0) {
						d = d + incE;
						x = x + 1;
						y = y + 1;

					} else {
						d = d + incNE;
						y = y + 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			}

		} else if ((x1 >= x2) && (y1 < y2)) { // 2quadrante

			if (dx <= dy) {

				d = dy - 2 * dx;
				incE = 2 * (dy - dx);
				incNE = 2 * (-dx);

				modelo.addRow(new Object[] { d, x, y });

				while (y < y2) {

					if (d < 0) {
						d = d + incE;
						x = x - 1;
						y = y + 1;

					} else {
						d = d + incNE;
						y = y + 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			} else if (dx > dy) {

				d = 2 * dy - dx;
				incE = 2 * dy;
				incNE = 2 * (dy - dx);
				modelo.addRow(new Object[] { d, x, y });

				while (x > x2) {
					if (d <= 0) {
						d = d + incE;
						x = x - 1;

					} else {
						d = d + incNE;
						x = x - 1;
						y = y + 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			}

		} else if ((x1 > x2) && (y1 >= y2)) { // 3quadrante

			if (dx >= dy) {

				d = 2 * dy - dx;
				incE = 2 * dy;
				incNE = 2 * (dy - dx);

				modelo.addRow(new Object[] { d, x, y });

				while (x > x2) {
					if (d <= 0) {
						d = d + incE;
						x = x - 1;

					} else {
						d = d + incNE;
						x = x - 1;
						y = y - 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			} else if (dx < dy) {
				d = dy - 2 * dx;
				incE = 2 * (dy - dx);
				incNE = 2 * (-dx);

				modelo.addRow(new Object[] { d, x, y });

				while (y > y2) {

					if (d < 0) {
						d = d + incE;
						x = x - 1;
						y = y - 1;

					} else {
						d = d + incNE;
						y = y - 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			}

		} else if ((x1 <= x2) && (y1 > y2)) { // 4quadrante

			if (dx <= dy) {
				d = dy - 2 * dx;
				incE = 2 * (dy - dx);
				incNE = 2 * (-dx);

				modelo.addRow(new Object[] { d, x, y });

				while (y > y2) {

					if (d < 0) {
						d = d + incE;
						x = x + 1;
						y = y - 1;

					} else {
						d = d + incNE;
						y = y - 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			} else if (dx > dy) {
				d = 2 * dy - dx;
				incE = 2 * dy;
				incNE = 2 * (dy - dx);

				modelo.addRow(new Object[] { d, x, y });

				while (x < x2) {
					if (d <= 0) {
						d = d + incE;
						x = x + 1;

					} else {
						d = d + incNE;
						x = x + 1;
						y = y - 1;
					}

					coorA = TransformacaoDispositivo2D.transformaPontosX(x);
					coorB = TransformacaoDispositivo2D.transformaPontosY(y);

					modelo.addRow(new Object[] { d, x, y });

					TelaPainel.setPixel(coorA, coorB, cor);
				}

			}

		}

	}
}