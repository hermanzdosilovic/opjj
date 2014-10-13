package hr.fer.zemris.primjer.okvirnametoda;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public abstract class ApstraktniCitac<T> {
	
	private String fileName;
	
	public ApstraktniCitac(String fileName) throws IOException {
		this.fileName = fileName;
		procitajDatoteku();
	}
	
	public void procitajDatoteku() throws IOException {
		int ocekivaniBrojStupaca = dohvatiOcekivaniBrojStupaca();
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
				staviPodatak(elems);
			}
		} finally {
			if(br!=null) {
				try { br.close(); } catch(Exception ignorable) {}
			}
		}
	}
	
	protected abstract void staviPodatak(String[] elems);

	protected abstract int dohvatiOcekivaniBrojStupaca();
	
	protected abstract T dohvatiKolekciju();
	
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
