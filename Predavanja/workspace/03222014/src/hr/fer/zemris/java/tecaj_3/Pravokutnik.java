package hr.fer.zemris.java.tecaj_3;

import hr.fer.zemris.java.tecaj_3.prikaz.Slika;

public class Pravokutnik extends GeometrijskiLik {

	private int vrhX;
	private int vrhY;
	private int sirina;
	private int visina;

	public Pravokutnik(int vrhX, int vrhY, int sirina, int visina) {
		super();
		this.vrhX = vrhX;
		this.vrhY = vrhY;
		this.sirina = sirina;
		this.visina = visina;
	}

	public int getVrhX() {
		return vrhX;
	}

	public int getVrhY() {
		return vrhY;
	}

	public int getSirina() {
		return sirina;
	}

	public int getVisina() {
		return visina;
	}

	public Pravokutnik() {
	}

	@Override
	public boolean sadrziTocku(int x, int y) {
		if (x < vrhX)
			return false;
		if (y < vrhY)
			return false;
		if (x >= vrhX + sirina)
			return false;
		if (y >= vrhY + visina)
			return false;
		return true;
	}

	@Override
	public void popuniLik(Slika slika) {
		for(int y = vrhY, yKraj = vrhY + visina, xKraj = vrhX + sirina; y < yKraj; y++) {
			for(int x = vrhX; x < xKraj; x++) {
				slika.upaliTocku(x, y);
			}
		}
	}
	

}
