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

import view.TelaPainel;

public class TransformacaoDispositivo2D {

	/**
	 * Converte o ponto X da coordenada do usuario para a coordenada do dispositivo
	 * Tem como parametro dcx
	 * 
	 * @param dcx Retorna o ponto Y transformado
	 * @return
	 */

	public static int transformaPontosX(int dcx) {
		int x;
		x = (dcx * TelaPainel.x - dcx + (TelaPainel.x / 2) * TelaPainel.x - (TelaPainel.x / 2))
				/ (2 * (TelaPainel.x / 2) - 1);
		return x;

	}

	/**
	 * Converte o ponto X da coordenada do usuario para a coordenada do dispositivo
	 * Tem como parametro dcx
	 * 
	 * @param dcx Retorna o ponto Y transformado
	 * @return
	 */

	public static int transformaPontosY(int dcy) {
		int y;
		y = ((TelaPainel.y - 1) - ((TelaPainel.y / 2 - 1) + dcy));
		return y;
	}

}