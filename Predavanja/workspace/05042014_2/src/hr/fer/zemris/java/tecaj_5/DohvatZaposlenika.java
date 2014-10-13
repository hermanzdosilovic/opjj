package hr.fer.zemris.java.tecaj_5;

import java.util.ArrayList;
import java.util.List;

public class DohvatZaposlenika {

	public static void main(String[] args) {

		List<Zaposlenik> lista = new ArrayList<>();

		lista.add(new Zaposlenik("1", "Pero", "Perić"));
		lista.add(new Zaposlenik("2", "Agata", "Agić"));
		lista.add(new Zaposlenik("3", "Iva", "Ivić"));

		for (Zaposlenik z : lista) {
			System.out.println(z);
		}

		Zaposlenik zaposlenik = new Zaposlenik("1", "Pero", "Perić");
		boolean sadrziZaposlenika = lista.contains(zaposlenik);
		System.out.println("SadrziZaposlenika = " + sadrziZaposlenika);

		/*
		 * List<Zaposlenik> novaLista = new ArrayList<>(lista);
		 * 
		 * // zelim iz nove liste izbaciti sve zaposlenike cija je sifra neparna
		 * // koristim iterator zbog izbacivanja elem iz liste
		 * 
		 * Iterator<Zaposlenik> it = novaLista.iterator(); while (it.hasNext())
		 * { Zaposlenik z = it.next(); int zadnjaZnamenka =
		 * Integer.parseInt(z.getSifra().substring(z.getSifra().length() - 1));
		 * 
		 * if ((zadnjaZnamenka % 2) == 1) { it.remove(); } }
		 * System.out.println(); for (Zaposlenik z : novaLista) {
		 * System.out.println(z); }
		 */
	}
}
