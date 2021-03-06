package hr.fer.zemris.java.tecaj_6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class PisanjeDatoteke {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException {

		OutputStream os = new FileOutputStream("D:/datoteka.dat");
		MojOutputStream ms = new MojOutputStream(os);

		SecretKey kljuc = new SecretKeySpec("AQWSAQWSAQWSAQWS".getBytes(), "AES");
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		c.init(Cipher.ENCRYPT_MODE, kljuc);
		CipherOutputStream cos = new CipherOutputStream(ms, c);
		metoda(cos);

		os.close();

	}

	private static void metoda(OutputStream os) throws IOException {
		String poruka = "Ovo je poruka koja ide u datoteku.";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			sb.append(poruka);
			sb.append("\r\n");
		}

		// ne pisati nikad vise!
		// byte[] podaci = sb.toString().getBytes();

		// ispravno:
		byte[] podaci = sb.toString().getBytes(StandardCharsets.UTF_8);

		for (int i = 0; i < podaci.length; i++) {
			os.write(podaci[i]);
		}
	}
}
