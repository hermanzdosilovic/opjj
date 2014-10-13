package mreza.m1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Primjer1 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress addr1 = InetAddress.getLocalHost();
		System.out.println("Lokalna adresa računala: " + addr1);
		System.out.println();
		
		InetAddress addr2 = InetAddress.getByAddress(new byte[] {
				(byte)161,
				(byte)53,
				(byte)65,
				(byte)224
		});
		
		System.out.println("Adresa 2 je: " + addr2);
		System.out.println("Adresa 2 - hostName: " + addr2.getHostName());
		System.out.println("Adresa 2 - canonicalHostName: " + addr2.getCanonicalHostName());
		
		InetAddress addr3 = InetAddress.getLoopbackAddress();
		System.out.println("Loopback adresa računala: " + addr3);
		System.out.println();
		
		InetAddress addr4 = InetAddress.getByName("java.zemris.fer.hr");
		System.out.println("java.zemris.fer.hr adresa računala: " + addr4);
		System.out.println();
		
		InetAddress[] sveAdrese = InetAddress.getAllByName("www.google.com");
		for(InetAddress a : sveAdrese) {
			System.out.println("www.google.com adresa računala: " + a);
		}

	}

}
