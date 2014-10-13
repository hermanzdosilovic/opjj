package mreza.m1;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Primjer2 {

	public static void main(String[] args) throws SocketException {
		Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();
		while(nics.hasMoreElements()) {
			NetworkInterface nic = nics.nextElement();
			System.out.format("%d: %s (%s)%n", nic.getIndex(), nic.getName(), nic.getDisplayName());
			byte[] mac = nic.getHardwareAddress();
			if(mac == null) {
				System.out.println(" Mack: nema");
			}
			else {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < mac.length; i++) {
					if(sb.length() != 0) sb.append(":");
					sb.append(String.format("%02x", mac[i]));
				}
				System.out.println(" Mac: " + sb.toString());
			}
			Enumeration<InetAddress> adrese = nic.getInetAddresses();
			while(adrese.hasMoreElements()) {
				InetAddress a = adrese.nextElement();
				System.out.println(" Inet: " + a);
			}
		}

	}

}
