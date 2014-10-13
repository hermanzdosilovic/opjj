package hr.fer.zemris.java.tecaj_5;

import java.io.File;

public class Ispisi {

	public interface Posao {
		public void udiUDirektorij(File dir);

		public void izadiIzDirektorija(File dir);

		public void obradiDatoteku(File f);

	}

	public static void printFile(File f) {
		File[] child = f.listFiles();
		if (child == null)
			return;
		for (File c : child) {
			System.out.println("\t" + c.getName());
			if (c.isDirectory()) {
				printFile(c);
			}
		}
	}
	
	public static void obradi(File direktorij, Posao posao) {
		File[] child = direktorij.listFiles();
		if (child == null)
			return;
		for (File c : child) {
			if(c.isFile()) {
				posao.obradiDatoteku(c);
			}
			else if(c.isDirectory()) {
				obradi(c, posao);
				posao.izadiIzDirektorija(c);
			}
			System.out.println("\t" + c.getName());
			if (c.isDirectory()) {
				printFile(c);
			}
		}
	}
	
	public static void main(String[] args) {
		File dir = new File("c:/windows");
		printFile(dir);
		VelicinaDatoteka v = new VelicinaDatoteka();
		obradi(dir, v);
		System.out.println(v.getUkupnaVelicina());
	}
	
	public class VelicinaDatoteka implements Posao {
		private long ukupnaVelicina = 0;
		
		public int getUkupnaVelicina() {
			return (int) ukupnaVelicina;
		}
		
		@Override
		public void udiUDirektorij(File dir) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void izadiIzDirektorija(File dir) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void obradiDatoteku(File f) {
			ukupnaVelicina += f.length();
			
		}
	}
}
