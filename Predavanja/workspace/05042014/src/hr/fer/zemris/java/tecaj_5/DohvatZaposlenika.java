package hr.fer.zemris.java.tecaj_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DohvatZaposlenika {

	public static void main(String[] args) {

		List<Zaposlenik> lista = new ArrayList<>();

		lista.add(new Zaposlenik("1", "Pero", "Perić"));
		lista.add(new Zaposlenik("2", "Agata", "Agić"));
		lista.add(new Zaposlenik("3", "Ivana", "Ivić"));

//		for (Zaposlenik z : lista) {
//			System.out.println(z);
//		}

		List<Zaposlenik> novaLista = new ArrayList<>(lista);

		// Želim iz nove liste izbaciti sve zaposlenike čija je šifra neparna
		
		Iterator<Zaposlenik> it = novaLista.iterator();
		while(it.hasNext()) {
			Zaposlenik z = it.next();
			int zadnjaZnamenka = Integer.parseInt(z.getSifra().substring(z.getSifra().length() - 1));
			if((zadnjaZnamenka % 2) == 1) {
				it.remove();
			}
		}
		
		for (Zaposlenik z : novaLista) {
			System.out.println(z);
		}
		
		Zaposlenik trazeni = new Zaposlenik("1", "Pero", "Perić");
		boolean postoji = lista.contains(trazeni);
		System.out.println("Postoji u listi: " + postoji);
	}
}
