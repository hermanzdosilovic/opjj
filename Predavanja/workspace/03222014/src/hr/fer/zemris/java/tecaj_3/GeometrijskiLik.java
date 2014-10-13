package hr.fer.zemris.java.tecaj_3;

import hr.fer.zemris.java.tecaj_3.prikaz.Slika;

public class GeometrijskiLik {

	public GeometrijskiLik() {
	}

//	public boolean sadrziTocku(int x, int y);

	public void popuniLik(Slika slika) {
		for (int y = 0, yKraj = slika.getVisina(); y < yKraj; y++) {
			for (int x = 0, xKraj = slika.getSirina(); x < xKraj; x++) {
				if (sadrziTocku(x, y)) {
					slika.upaliTocku(x, y);
				}
			}
		}
	}

}
