package primjer;

public class Pravokutink extends GeometrijskiLik {
	
	private int vrhX;
	private int vrhY;
	private int sirina;
	private int visina;

	public Pravokutink(String ime, int vrhX, int vrhY, int sirina, int visina) {
		super(ime);
		this.vrhX = vrhX;
		this.vrhY = vrhY;
		this.sirina = sirina;
		this.visina = visina;
	}
	
	public double getPovrsina() {
		return sirina * visina;
	}
	
	@Override
	public double getOpseg() {
		return 2 * (visina + sirina);
	}
}
