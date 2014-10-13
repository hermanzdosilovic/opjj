package primjer;

public class Primjer00 {
		
	public static void main(String[] args) {
		Pravokutink p = new Pravokutink("asdf", 20, 20, 10, 10);
		GeometrijskiLik l = p;
		System.out.println(l.getOpseg());
		System.out.println(p.getPovrsina());
		System.out.println(p.getOpseg());
	}

}
