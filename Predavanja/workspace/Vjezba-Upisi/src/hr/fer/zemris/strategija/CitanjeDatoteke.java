package hr.fer.zemris.strategija;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CitanjeDatoteke {
	
	public static <T> T procitajDatoteku(String fileName, ObradaDatoteke<T> obradivac) throws IOException {
		int ocekivaniBrojStupaca = obradivac.dohvatiOcekivaniBrojStupaca();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
			while(true) {
				String line = br.readLine();
				if(line==null) break;
				line = mijenjajRedak(line);
				line = line.trim();
				if(line.isEmpty()) continue;
				String[] elems = line.split("\t");
				if(elems.length!=ocekivaniBrojStupaca) {
					System.out.println("Pogresan zapis!");
					continue;
				}
				obradivac.staviPodatak(elems);
			}
		} finally {
			if(br!=null) {
				try { br.close(); } catch(Exception ignorable) {}
			}
		}
		return obradivac.dohvatiKolekciju();
	}
	
	private static String mijenjajRedak(String line) {
		int pozicija = line.indexOf('#'); 
		if(pozicija>=0) {
			line = line.substring(0, pozicija);
		}
		pozicija = line.indexOf('%');
		if(pozicija>=0) {
			line = line.substring(0, pozicija);
		}
		if(line.contains("REM")) {
			line = "";
		}
		return line;
	}
	
}
