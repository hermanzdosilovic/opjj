package hr.fer.zemris.java.tecaj_5;

public class Glavni2 {
	
	public static void main(String[] args) {
		Integer i = new Integer(17);
		
		Pointer<Integer> p = new Pointer<>(i);
		obradi(p);
		
		System.out.println(p.getValue());		
		
	}
	
	private static void obradi(Pointer<Integer> p){
		System.out.println("U metodi dobio sam: " + p.getValue());
		p.setValue(new Integer(24));
		System.out.println("U metodi modificirao sam: " + p.getValue());
	}
}
