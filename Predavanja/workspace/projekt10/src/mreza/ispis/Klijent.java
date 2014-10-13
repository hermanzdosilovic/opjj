package mreza.ispis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Klijent {

	public static void main(String[] args) throws UnknownHostException, IOException {

		if (args.length != 4) {
			System.out.println("Očekivao sam 4 argumenta: (IP|hostname) port username text");
			return;
		}

		InetAddress adresaPosluzitelja = InetAddress.getByName(args[0]);
		int portPosluzitelja = Integer.parseInt(args[1]);
		String username = args[2];
		String text = args[3];

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		zapisi(bos, username);
		zapisi(bos, text);
		byte[] data = bos.toByteArray();

		DatagramSocket socket = new DatagramSocket();
		DatagramPacket zahtjev = new DatagramPacket(data, data.length);
		zahtjev.setAddress(adresaPosluzitelja);
		zahtjev.setPort(portPosluzitelja);

		while (true) {

			System.out.println("Šaljem zahtjev.");
			socket.send(zahtjev);
			byte[] buf = new byte[1024];
			DatagramPacket odgovor = new DatagramPacket(buf, buf.length);

			socket.setSoTimeout(3000);
			try {
				socket.receive(odgovor);
			} catch (SocketTimeoutException ex) {
				System.out.println("Nisam dočekao odgovor. Idem ponovo slati!");
				continue;
			}

			if (odgovor.getLength() != 1) {
				System.out.println("Nešto sam dobio, ali to nije očekivani odgovor. Idem ponovo slati!");
				continue;
			}

			byte podatak = odgovor.getData()[odgovor.getOffset()];
			if (podatak != 1) {
				System.out.println("Nešto sam dobio, ali to nije očekivani odgovor. Idem ponovo slati!");
				continue;
			}

			break;
		}

		System.out.println("Dobio sam potvrdu.");

		socket.close();

	}

	private static void zapisi(ByteArrayOutputStream bos, String s) throws IOException {
		byte[] spremnik = s.getBytes(StandardCharsets.UTF_8);
		if (spremnik.length > 255) {
			throw new RuntimeException("String je predugačak.");
		}
		bos.write(spremnik.length);
		bos.write(spremnik);
	}

}
