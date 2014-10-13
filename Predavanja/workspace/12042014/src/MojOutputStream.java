import java.io.IOException;
import java.io.OutputStream;

public class MojOutputStream extends OutputStream {

	private byte[] spremnik = new byte[1024];
	private int zauzece;
	private OutputStream originalni;
	
	public MojOutputStream(OutputStream originalni) {
		super();
		this.originalni = originalni;
	}
	
	@Override
	public void write(int b) throws IOException {
		if(zauzece >= spremnik.length) {
			flush();
		}
		
		spremnik[zauzece] = (byte) b;
		zauzece++;
	}
	
	@Override
	public void flush() throws IOException {
		if(zauzece > 0) {
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
