package hr.fer.zemris.java.tecaj_5;

public class Glavni {
	
	public static void main(String[] args) {
		Integer i = new Integer(17);
		
		obradi(i);
		
		System.out.println(i);		
		
	}
	
	private static void obradi(Integer i){
		System.out.println("U metodi dobio sam: " + i);
		i = new Integer(24);
		System.out.println("U metodi modificirao sam: " + i);
	}

}
