package mreza.http;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Posluzitelj {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.println("Očekivao sam port i vršni direktorij za web");
			return;
		}

		int port = Integer.parseInt(args[0]);
		Path documentRoot = Paths.get(args[1]);

		ServerSocket ssocket = new ServerSocket(port);
		while (true) {
			Socket klijent = ssocket.accept();
			// u novoj dretvi obradi klijenta
			obradi(documentRoot, klijent);
		}
	}

	private static void obradi(Path documentRoot, Socket klijent) throws IOException {
		
		InputStream is = klijent.getInputStream();
		BufferedReader r = new BufferedReader(new InputStreamReader(new BufferedInputStream(is),
		        StandardCharsets.ISO_8859_1));
		String prviRedak = r.readLine();
		while (true) {
			String ostalo = r.readLine();
			if (ostalo.isEmpty())
				break;
			System.out.println(ostalo);
		}

		String[] dijelovi = prviRedak.split(" ");
		if (!dijelovi[0].equalsIgnoreCase("GET")) {
			posaljiGresku(klijent, 500, "text/plain", "Loš zahtjev.");
			return;
		}
		
		System.out.println("Tražen je dokument: " + dijelovi[1]);
		Path stvarna = documentRoot.resolve("." + dijelovi[1]);

		String root = documentRoot.toFile().getCanonicalPath();
		String dobiveni = stvarna.toFile().getCanonicalPath();
		if (!dobiveni.startsWith(root)) {
			posaljiGresku(klijent, 500, "text/plain", "Nelegalan zahtjev");
			return;
		}

		if (!Files.exists(stvarna)) {
			posaljiGresku(klijent, 404, "text/plain", "Datoteka ne postoji");
			return;
		}

		byte[] sadrzajDatoteke = Files.readAllBytes(stvarna);

		vratiOdgovor(klijent, 200, utvrdiMimeTip(stvarna.getFileName().toString()), sadrzajDatoteke);
	}

	private static void vratiOdgovor(Socket klijent, int status, String mime, byte[] sadrzaj) throws IOException {
		if(mime.startsWith("text/")) {
			mime = mime + ";charset=utf-8";
		}

		String odgovor = "HTTP/1.1" + status + "OK\r\n" + "Content-Type: " + mime + ";charset=utf-8\r\n"
		        + "Content-Length: " + sadrzaj.length + "\r\n" + "\r\n";

		klijent.getOutputStream().write(odgovor.getBytes(StandardCharsets.ISO_8859_1));
		klijent.getOutputStream().write(sadrzaj);
		klijent.getOutputStream().flush();
		klijent.close();
	}

	private static String utvrdiMimeTip(String name) {
		int tocka = name.lastIndexOf(".");
		if (tocka == -1) {
			return "application/octet-stream";
		}

		String ekstenzija = name.substring(tocka + 1).toLowerCase();
		if (ekstenzija.equals("html") || ekstenzija.equals("htm")) {
			return "text/html";
		}
		if (ekstenzija.equals("jpg")) {
			return "image/jpg";
		}
		if (ekstenzija.equals("gif")) {
			return "image/gif";
		}
		if (ekstenzija.equals("png")) {
			return "image/png";
		}
		return "application/octet-stream";
	}

	private static void posaljiGresku(Socket klijent, int status, String mime, String poruka) throws IOException {
		byte[] data = poruka.getBytes(StandardCharsets.UTF_8);

		String odgovor = "HTTP/1.1" + status + "OK\r\n" + "Content-Type: " + mime + ";charset=utf-8\r\n"
		        + "Content-Length: " + data.length + "\r\n" + "\r\n";

		klijent.getOutputStream().write(odgovor.getBytes(StandardCharsets.ISO_8859_1));
		klijent.getOutputStream().write(data);
		klijent.getOutputStream().flush();
		klijent.close();
	}

}
