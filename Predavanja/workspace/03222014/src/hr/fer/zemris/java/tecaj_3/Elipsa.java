package hr.fer.zemris.java.tecaj_3;

public class Elipsa extends GeometrijskiLik {

	private int centarX;
	private int centarY;
	private int rX;
	private int rY;

	public Elipsa(int centarX, int centarY, int rX, int rY) {
		super();
		this.centarX = centarX;
		this.centarY = centarY;
		this.rX = rX;
		this.rY = rY;
	}
	
	
	@Override
	public boolean sadrziTocku(int x, int y) {
		return false;
	}


	public Elipsa() {
	}

	public int getCentarX() {
		return centarX;
	}

	public int getCentarY() {
		return centarY;
	}

	public int getrX() {
		return rX;
	}

	public int getrY() {
		return rY;
	}

}
