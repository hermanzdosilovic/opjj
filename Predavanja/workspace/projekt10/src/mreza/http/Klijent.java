package mreza.http;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Klijent {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("java.zemris.fer.hr", 80);
		
		String zahtjev = 
				"GET /index.jsp HTTP/1.1\r\n" + 
				"Host: java.zemris.fer.hr\r\n" + 
				"User-Agent: java-klijent\r\n" + 
				"Connection: close\r\n" + 
				"\r\n";
		
		byte[] data = zahtjev.getBytes(StandardCharsets.ISO_8859_1);
		
		socket.getOutputStream().write(data);
		socket.getOutputStream().flush();
		
		while(true) {
			int znak = socket.getInputStream().read();
			if(znak == -1) {
				break;
			}
			System.out.print((char)znak);
		}
		
		socket.close();
	}

}
