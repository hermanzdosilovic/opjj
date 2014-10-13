package primjer;

public class Linija extends GeometrijskiLik {
	
	private int x0;
	private int y0;
	private int x1;
	private int y1;
	
	public Linija(String ime, int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.ime = ime;
	}

	public int getX0() {
		return x0;
	}

	public int getY0() {
		return y0;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}
	
	

}
