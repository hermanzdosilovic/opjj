package hr.fer.zemris.java.tecaj_3.testovi;

import hr.fer.zemris.java.tecaj_3.GeometrijskiLik;
import hr.fer.zemris.java.tecaj_3.Pravokutnik;
import hr.fer.zemris.java.tecaj_3.Kvadrat;
import hr.fer.zemris.java.tecaj_3.prikaz.PrikaznikSlike;
import hr.fer.zemris.java.tecaj_3.prikaz.Slika;

public class Program1 {

	public static void main(String[] args) {
		GeometrijskiLik[] likovi = new GeometrijskiLik[] {
				new Pravokutnik(10, 10, 5, 20),
				new Pravokutnik(16, 10, 20, 10),
				new Kvadrat(1, 1, 7)
		};
		
		Pravokutnik p = (Pravokutnik) new GeometrijskiLik();
		Slika slika = new Slika(40, 40);
		
		for(GeometrijskiLik lik : likovi) {
			lik.popuniLik(slika);
		}
		
//		slika.nacrtajSliku(System.out);
		
		PrikaznikSlike.prikaziSliku(slika, 10);
	}

}
