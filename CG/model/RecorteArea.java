package model;

/**
 * Universidade Estadual da Paraiba Departamento de Computacao Curso de
 * Licenciatura Plena em Computacao Componente Curricular: Computacao Grafica
 * Professor: Robson Pequeno Equipe: Arthur Felipe Thamay Medeiros, Jefferson
 * Felipe Silva de Lima, Thalles Gutembergh dos Santos 2012.2
 */

public class RecorteArea {

	/**
	 * Atributos
	 */
	int Xmin;
	int Xmax;
	int Ymin;
	int Ymax;

	public RecorteArea(int xmin, int xmax, int ymin, int ymax) {

		this.Xmin = xmin;
		this.Xmax = xmax;
		this.Ymin = ymin;
		this.Ymax = ymax;

	}

	// Getters and setters
	public int getXmin() {
		return Xmin;
	}

	public void setXmin(int xmin) {
		Xmin = xmin;
	}

	public int getXmax() {
		return Xmax;
	}

	public void setXmax(int xmax) {
		Xmax = xmax;
	}

	public int getYmin() {
		return Ymin;
	}

	public void setYmin(int ymin) {
		Ymin = ymin;
	}

	public int getYmax() {
		return Ymax;
	}

	public void setYmax(int ymax) {
		Ymax = ymax;
	}

	/**
	 * Método que executa o And Lógico para verificação de reta candidata a recorte
	 * 
	 * @param ponto1
	 * @param ponto2
	 * @return
	 */

	public static String andLogico(String ponto1, String ponto2) {
		String verifica = "";
		for (int i = 0; i < ponto1.length(); i++) {
			if (ponto1.charAt(i) == '1' && ponto2.charAt(i) == '1') {
				verifica += "" + 1;
			} else {
				verifica += "" + 0;
			}

		}
		return verifica;

	}

	/**
	 * Método que executa o recorte da reta (de acordo com a candidata vencedora no
	 * and logico) e verifica em qual área encontram-se os pontos da reta para serem
	 * recortados e adequados a dimensão da viewport
	 * 
	 * @param reta
	 * @param area
	 * @return
	 */
	public static RetaRecorte algoritmoRecorte(RetaRecorte reta, RecorteArea area) {
		String ponto1 = "";
		String ponto2 = "";
		if (candidatoRecorte(reta, area)) {
			ponto1 = codigoPonto1(reta, area);
			ponto2 = codigoPonto2(reta, area);

			while (andLogico(ponto1, ponto2).equals("0000")) {
				if (!ponto1.equals("0000")) {
					int x1 = 0;
					int y1 = 0;
					if (ponto1.charAt(0) == '1') {

						y1 = area.getYmax();
						double t = (double) ((y1 - reta.getY1()) / (double) (reta.getY2() - reta.getY1()));
						x1 = (int) Math.round(reta.getX1() + t * (reta.getX2() - reta.getX1()));

						reta.setX1(x1);
						reta.setY1(y1);

					} else if (ponto1.charAt(1) == '1') {
						y1 = area.getYmin();
						double t = (double) ((y1 - reta.getY1()) / (double) (reta.getY2() - reta.getY1()));
						x1 = (int) Math.round(reta.getX1() + t * (reta.getX2() - reta.getX1()));
						reta.setX1(x1);
						reta.setY1(y1);

					} else if (ponto1.charAt(2) == '1') {
						x1 = area.getXmax();
						double t = (double) ((x1 - reta.getX1()) / (double) (reta.getX2() - reta.getX1()));
						y1 = (int) Math.round(reta.getY1() + t * (reta.getY2() - reta.getY1()));
						reta.setX1(x1);
						reta.setY1(y1);

					} else if (ponto1.charAt(3) == '1') {
						x1 = area.getXmin();
						double t = (double) ((x1 - reta.getX1()) / (double) (reta.getX2() - reta.getX1()));
						y1 = (int) Math.round(reta.getY1() + t * (reta.getY2() - reta.getY1()));
						reta.setX1(x1);
						reta.setY1(y1);

					}

				}

				if (!ponto2.equals("0000")) {
					int x1 = 0;
					int y1 = 0;
					if (ponto2.charAt(0) == '1') {
						y1 = area.getYmax();
						double t = (double) ((y1 - reta.getY1()) / (double) (reta.getY2() - reta.getY1()));
						x1 = (int) Math.round(reta.getX1() + t * (reta.getX2() - reta.getX1()));
						reta.setX2(x1);
						reta.setY2(y1);

					} else if (ponto2.charAt(1) == '1') {
						y1 = area.getYmin();
						double t = (double) ((y1 - reta.getY1()) / (double) (reta.getY2() - reta.getY1()));
						x1 = (int) Math.round(reta.getX1() + t * (reta.getX2() - reta.getX1()));
						reta.setX2(x1);
						reta.setY2(y1);

					} else if (ponto2.charAt(2) == '1') {
						x1 = area.getXmax();
						double t = (double) ((x1 - reta.getX1()) / (double) (reta.getX2() - reta.getX1()));
						y1 = (int) Math.round(reta.getY1() + t * (reta.getY2() - reta.getY1()));
						reta.setX2(x1);
						reta.setY2(y1);

					} else if (ponto2.charAt(3) == '1') {
						x1 = area.getXmin();
						double t = (double) ((x1 - reta.getX1()) / (double) (reta.getX2() - reta.getX1()));
						y1 = (int) Math.round(reta.getY1() + t * (reta.getY2() - reta.getY1()));
						reta.setX2(x1);
						reta.setY2(y1);

					}

				}

				ponto1 = "" + sinal(reta.getY1() - area.getYmax());
				ponto1 += "" + sinal(area.getYmin() - reta.getY1());
				ponto1 += "" + sinal(reta.getX1() - area.getXmax());
				ponto1 += "" + sinal(area.getXmin() - reta.getX1());

				ponto2 = "" + sinal(reta.getY2() - area.getYmax());
				ponto2 += "" + sinal(area.getYmin() - reta.getY2());
				ponto2 += "" + sinal(reta.getX2() - area.getXmax());
				ponto2 += "" + sinal(area.getXmin() - reta.getX2());

				if (ponto1.equals("0000") && ponto2.equals("0000")) {
					break;

				}

			}

			if (!andLogico(ponto1, ponto2).equals("0000")) {
				reta = null;
			}

			return reta;

		} else {
			reta = null;
			return reta;

		}

	}

	/**
	 * Calcula os bits do ponto1
	 * 
	 * @param reta
	 * @param area
	 * @return
	 */
	public static String codigoPonto1(RetaRecorte reta, RecorteArea area) {
		String ponto1 = "" + sinal(reta.getY1() - area.getYmax());
		ponto1 += "" + sinal(area.getYmin() - reta.getY1());
		ponto1 += "" + sinal(reta.getX1() - area.getXmax());
		ponto1 += "" + sinal(area.getXmin() - reta.getX1());

		return ponto1;

	}

	/**
	 * Calcula os bits do ponto2
	 * 
	 * @param reta
	 * @param area
	 * @return
	 */
	public static String codigoPonto2(RetaRecorte reta, RecorteArea area) {
		String ponto2 = "" + sinal(reta.getY2() - area.getYmax());
		ponto2 += "" + sinal(area.getYmin() - reta.getY2());
		ponto2 += "" + sinal(reta.getX2() - area.getXmax());
		ponto2 += "" + sinal(area.getXmin() - reta.getX2());

		return ponto2;

	}

	public static boolean candidatoRecorte(RetaRecorte reta, RecorteArea area) {
		String ponto1 = "" + sinal(reta.getY1() - area.getYmax());
		ponto1 += "" + sinal(area.getYmin() - reta.getY1());
		ponto1 += "" + sinal(reta.getX1() - area.getXmax());
		ponto1 += "" + sinal(area.getXmin() - reta.getX1());

		String ponto2 = "" + sinal(reta.getY2() - area.getYmax());
		ponto2 += "" + sinal(area.getYmin() - reta.getY2());
		ponto2 += "" + sinal(reta.getX2() - area.getXmax());
		ponto2 += "" + sinal(area.getXmin() - reta.getX2());

		String verifica = "";

		for (int i = 0; i < ponto1.length(); i++) {
			if (ponto1.charAt(i) == '1' && ponto2.charAt(i) == '1') {
				verifica += "" + 1;
			} else {
				verifica += "" + 0;

			}

		}

		System.out.println(verifica);
		if (verifica.equals("0000")) {
			return true;
		} else {
			return false;
		}

	}

	public static int sinal(int x) {
		int sinal;
		if (x <= 0) {
			sinal = 0;
		} else {
			sinal = 1;
		}
		return sinal;

	}

}