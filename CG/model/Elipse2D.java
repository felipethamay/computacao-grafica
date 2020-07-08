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

import view.TelaElipse;
import view.TelaPainel;

public class Elipse2D {

	/**
	 * Desenha a elipse em todos os quadrantes Tem como parametro um valor em x
	 * passado pelo usuario
	 * 
	 * @param x Tem como parametro um valor em y passado pelo usuario
	 * @param y
	 */
	public static void elipsePontos(int x, int y) {

		int cor[] = new int[3];
		cor[0] = 0;
		cor[1] = 0;
		cor[2] = 255;
		int coordX = TransformacaoDispositivo2D.transformaPontosX(x);
		int coordY = TransformacaoDispositivo2D.transformaPontosY(y);
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX(x);
		coordY = TransformacaoDispositivo2D.transformaPontosY(-y);
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX(-x);
		coordY = TransformacaoDispositivo2D.transformaPontosY(y);
		TelaPainel.setPixel(coordX, coordY, cor);

		coordX = TransformacaoDispositivo2D.transformaPontosX(-x);
		coordY = TransformacaoDispositivo2D.transformaPontosY(-y);
		TelaPainel.setPixel(coordX, coordY, cor);

	}

	/**
	 * Tem como parametro o valor de a
	 * 
	 * @param a Tem como parametro o valor de B
	 * @param b
	 */
	public static void algorimoElipse(int a, int b) {
		DefaultTableModel modelo = (DefaultTableModel) TelaElipse.jTable1.getModel();
		modelo.setRowCount(0);

		int x, y;
		double d1, d2;

		x = 0;
		y = b;
		// dinit
		d1 = ((b * b) - (a * a * b) + (a * a)) / 4.0;

		elipsePontos(x, y);

		// e
		while ((a * a * (y - 0.5)) > (b * b * (x + 1))) {
			if (d1 < 0) {
				d1 += b * b * (2 * x + 3);
				x++;

				// se
			} else {
				d1 += b * b * (2 * x + 3) + a * a * (-2 * y + 2);
				x++;
				y--;
			}

			modelo.addRow(new Object[] { x, y });
			elipsePontos(x, y);
		}

		// dinit d2
		d2 = ((b * b) * (x - 0.5) * (x - 0.5)) + ((a * a) * (y - 1) * (y - 1)) - (a * a * b * b);

		while (y > 0) {
			if (d2 < 0) {
				d2 += (b * b * (2 * x + 2)) + (a * a * (-2 * y + 3));
				x++;
				y--;

			} else {
				d2 += a * a * (-2 * y + 3);
				y--;
			}

			modelo.addRow(new Object[] { x, y });
			elipsePontos(x, y);

		}

	}

}
