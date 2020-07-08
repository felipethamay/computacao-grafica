package exceptions;

/**
 * Universidade Estadual da Paraiba Departamento de Computacao Curso de
 * Licenciatura Plena em Computacao Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno Equipe: Arthur Felipe Thamay Medeiros, Jefferson
 * Felipe Silva de Lima, Thalles Gutembergh dos Santos 2012.2
 */

public class FormatoImagemException extends Exception {

	// default serial version
	private static final long serialVersionUID = 1L;

	public FormatoImagemException() {
		super("O Arquivo nao e no formato PGM.");
	}

}
