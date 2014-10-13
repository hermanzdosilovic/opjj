package hr.fer.zemris.java.tecaj_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ZaposleniciTree {

	static class ReverzniKomparator implements Comparator<Zaposlenik> {

		private Comparator<Zaposlenik> originalni;

		public ReverzniKomparator(Comparator<Zaposlenik> originalni) {
			super();
			this.originalni = originalni;
		}

		@Override
		public int compare(Zaposlenik o1, Zaposlenik o2) {
			return -originalni.compare(o1, o2);
		}

	}
	
	public static final Comparator<Zaposlenik> PO_PREZIMENU = new Comparator<Zaposlenik>() {
		@Override
		public int compare(Zaposlenik o1, Zaposlenik o2) {
			return o1.getIme().compareTo(o2.getIme());
		}
	};
	
	public static final Comparator<Zaposlenik> PO_IMENU = new Comparator<Zaposlenik>() {
		@Override
		public int compare(Zaposlenik o1, Zaposlenik o2) {
			return o1.getIme().compareTo(o2.getIme());
		}
	};
	
	public static final Comparator<Zaposlenik> PO_SIFRI = new Comparator<Zaposlenik>() {
		@Override
		public int compare(Zaposlenik o1, Zaposlenik o2) {
			return o1.getIme().compareTo(o2.getIme());
		}
	};
	
	public static final Comparator<Zaposlenik> PO_PLACI = new Comparator<Zaposlenik>() {
		@Override
		public int compare(Zaposlenik o1, Zaposlenik o2) {
			return o1.getIme().compareTo(o2.getIme());
		}
	};
	
	public static class KompozitniKomparator implements Comparator<Zaposlenik> {
		
		private List<Comparator<Zaposlenik>> komparatori;
		
		public KompozitniKomparator(Comparator<Zaposlenik> ... komparatori) {
			super();
			this.komparatori = new ArrayList<>(Arrays.asList(komparatori));
		}

		@Override
		public int compare(Zaposlenik o1, Zaposlenik o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public static void main(String[] args) {

		Comparator<Zaposlenik> komparator = new Comparator<Zaposlenik>() {

			@Override
			public int compare(Zaposlenik o1, Zaposlenik o2) {
				int rez = o1.getPrezime().compareTo(o2.getPrezime());
				if (rez != 0) {
					return rez;
				}

				rez = o1.getIme().compareTo(o2.getIme());
				if (rez != 0) {
					return rez;
				}

				rez = o1.getSifra().compareTo(o2.getSifra());

				return rez;
			}
		};
		
		Comparator<Zaposlenik> reverzni = new ReverzniKomparator(komparator);
		Set<Zaposlenik> set = new TreeSet<>(reverzni);
		
		
		
		set.add(new Zaposlenik("1", "Pero", "Perić"));
		set.add(new Zaposlenik("2", "Agata", "Agić"));
		set.add(new Zaposlenik("3", "Ivana", "Ivić"));
		set.add(new Zaposlenik("4", "Jasmina", "Ivić"));
		set.add(new Zaposlenik("5", "Jasmina", "Ivić"));
		for (Zaposlenik z : set) {
			System.out.println(z);
		}
	}
}
