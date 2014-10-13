package hr.fer.zemris.java.tecaj4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Drugi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Collection<String> retci1 = Files.readAllLines(Paths.get("./prvi.txt"), StandardCharsets.UTF_8);
		
		Collection<String> retci2 = Files.readAllLines(Paths.get("./druga.txt"), StandardCharsets.UTF_8);
		
		Set<String> prvi = new HashSet<>();
		prvi.addAll(retci1);
		
		Set<String> drugi = new HashSet<>();
		drugi.addAll(retci2);
		
		prvi.removeAll(drugi);
		
		for(String ime : prvi) {
			System.out.println(ime);
		}
	}

}
