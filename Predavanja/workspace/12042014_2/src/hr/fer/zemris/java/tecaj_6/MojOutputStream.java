package hr.fer.zemris.java.tecaj_6;

import java.io.IOException;
import java.io.OutputStream;
/**
 * Koristi se oblikovni obrazac dekorator
 * @author Nicolette
 *
 */
public class MojOutputStream extends OutputStream {

	private byte[] spremnik = new byte[1024];
	private int zauzece;
	private OutputStream originalni;

	public MojOutputStream(OutputStream orginalni) {
		super();
		this.originalni = orginalni;
	}

	@Override
	public void write(int b) throws IOException {
		if(zauzece >= spremnik.length){
			flush();
		}
		
		if (zauzece < spremnik.length) {
			spremnik[zauzece] = (byte) b;
			zauzece++;
		}
	}
	
	@Override
	public void flush() throws IOException {
		if(zauzece > 0){
			originalni.write(spremnik, 0, zauzece);
			zauzece = 0;
		}
		originalni.flush();
	}
	
	@Override
	public void close() throws IOException {
		flush();
		originalni.close();
	}

}
