package hr.fer.zemris.java.tecaj_5;

import java.util.HashMap;
import java.util.Map;

public class Bonusi {

	public static void main(String[] args) {

		Map<Zaposlenik, Double> bonusi = new HashMap<>();

		bonusi.put(new Zaposlenik("1", "Pero", "Perić"), 100.0);
		bonusi.put(new Zaposlenik("2", "Agata", "Agić"), 200.0);
		bonusi.put(new Zaposlenik("3", "Ivana", "Ivić"), 300.0);

		for (Zaposlenik z : bonusi.keySet()) {
			Double bonus = bonusi.get(z);
			System.out.println(z + " ima bonus " + bonus);
		}
		System.out.println();
		Zaposlenik trazeni = new Zaposlenik("1", "Pero", "Perić");
		Double bonus = bonusi.get(trazeni);
		System.out.println(trazeni + " ima bonus " + bonus);

	}

}
