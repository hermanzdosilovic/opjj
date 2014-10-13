package hr.fer.zemris.java.tecaj_6;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IspisInfoEkstenzijeDirektorija {

	static class ExtInfo implements Comparable<ExtInfo> {
		private String ekstenzija;
		private int brojDatoteka;
		private long velicinaDatoteka;

		public ExtInfo(String ekstenzija) {
			super();
			this.ekstenzija = ekstenzija.toUpperCase();
			this.brojDatoteka = 0;
			this.velicinaDatoteka = 0;
		}

		public void dodaj(long velicina) {
			brojDatoteka++;
			velicinaDatoteka += velicina;

		}

		public String getEkstenzija() {
			return ekstenzija;
		}

		public int getBrojDatoteka() {
			return brojDatoteka;
		}

		public long getVelicinaDatoteka() {
			return velicinaDatoteka;
		}

		@Override
		public int compareTo(ExtInfo o) {
			return this.getEkstenzija().compareTo(o.getEkstenzija());
		}

	}

	static class Ispitivac implements FileVisitor<Path> {

		private Map<String, ExtInfo> mapa = new HashMap<>();

		@Override
		public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			String name = file.getName(file.getNameCount() - 1).toString();

			int pozicijaTocke = name.lastIndexOf('.');

			String ekstenzija = pozicijaTocke != -1 ? name.substring(pozicijaTocke + 1).toUpperCase() : "";
			ExtInfo info = mapa.get(ekstenzija);
			if (info == null) {
				info = new ExtInfo(ekstenzija);
				info.dodaj(file.toFile().length());
				mapa.put(ekstenzija, info);
			}
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
			return FileVisitResult.CONTINUE;
		}

		public void zavrsniIspis() {
			List<ExtInfo> lista = new ArrayList<>(mapa.values());
			Collections.sort(lista);
			System.out.println("Broj razlicitih ekstenzija: " + lista.size());
			for (ExtInfo e : lista) {
				System.out.printf("Ekstenzija \"%s\": broj datoteka je %d, ukupna velicina je %d%n ",
						e.getEkstenzija(), e.getBrojDatoteka(), e.getVelicinaDatoteka());
			}
		}

	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Dragi korisnice...");
			System.exit(-1);
		}

		Path p = Paths.get(args[0]);

		if (!Files.isDirectory(p)) {
			System.out.println("Dragi korisnice 2,...");
			System.exit(-1);
		}

		Ispitivac isp = new Ispitivac();
		Files.walkFileTree(p, isp);
		isp.zavrsniIspis();

	}

}
