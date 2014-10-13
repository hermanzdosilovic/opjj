package hr.fer.zemris.java.tecaj_5;

import java.io.File;

public class Ispisi {
	
	public interface Posao{
		
		public void udiUDirektorij(File dir);
		public void izadiIzDirektorija(File dir);
		public void obradiDatoteku(File f);
		
	}
	
	public static void obradi(File direktorij, Posao posao){
		File[] files = direktorij.listFiles();
		if(files == null) return;
		for(File c : files){
			if(c.isFile()){
				posao.obradiDatoteku(c);
			} else if(c.isDirectory()){
				posao.udiUDirektorij(c);
				obradi(c, posao);
				posao.izadiIzDirektorija(c);
			}
		}		
	}
	
	static class VelicinaDatoteke implements Posao{

		private long ukupnaVelicina = 0;
		
		@Override
		public void udiUDirektorij(File dir) {
			
		}

		@Override
		public void izadiIzDirektorija(File dir) {
			
		}

		@Override
		public void obradiDatoteku(File f) {
			ukupnaVelicina += f.length();
			
		}

		public long getUkupnaVelicina() {
			return ukupnaVelicina;
		}
		
	}
	
	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("Dragi korisnice, ...");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		
		System.out.println(dir.toString());
		if(!dir.isDirectory()){
			System.out.println("Nije direktorij!");
		} else {
			VelicinaDatoteke v = new VelicinaDatoteke();
			ispisi(dir, 2);
			obradi(dir, v);
			System.out.println("Ukupna velicina datoteka je: " + v.getUkupnaVelicina());
			
		}
		
		//System.out.println(ispisiBrojDir(dir, 2));
		
		
		
		
	}
	
	public static void ispisi(File dir, int indent){	
		File[] files = dir.listFiles();
		if(files == null) return;
		for(File c : files){
			System.out.printf("%" + indent + "s%s%n", "", c.getName());
			if(c.isDirectory()){
				ispisi(c, indent + 2);
			}
		}
	}
	
	/*public static double ispisiBrojDir(File dir, int indent){	
		File[] files = dir.listFiles();
		if(files == null) return 0;
		double broj = 0;
		for(File c : files){
			if(c.isDirectory()){
				broj = 1.0 + ispisiBrojDir(c, indent + 2);
			}
		}
		return broj;
	}*/

}
