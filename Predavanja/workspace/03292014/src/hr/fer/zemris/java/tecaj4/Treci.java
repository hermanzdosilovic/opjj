package hr.fer.zemris.java.tecaj4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Treci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		funkcija(args);
		funkcijaBolja(args);
		funkcijaJosBolja(args);
	}

	private static void funkcija(String[] args) {
		List<String> elementi = new ArrayList<>();
		
		for(String s: args) {
			if(elementi.contains(s)) {
				elementi.add(s);
			}
		}
		
		Collections.reverse(elementi);
		
		for(String s : elementi) {
			System.out.println(s);
		}
		
	}
	
	private static void funkcijaBolja(String[] args) {
		List<String> elementi = new ArrayList<>();
		Set<String> jedinstveniElementi = new HashSet<>();
		
		for(String s: args) {
			if(jedinstveniElementi.add(s)) {
				elementi.add(s);
			}
		}
		
		Collections.reverse(elementi);
		
		for(String s : elementi) {
			System.out.println(s);
		}
		
	}
	
	private static void funkcijaJosBolja(String[] args) {
		Set<String> jedinstveniElementi = new LinkedHashSet<>();
		
		for(String s: args) {
			jedinstveniElementi.add(s);
		}
		
		List<String> elementi = new ArrayList<>(jedinstveniElementi);
		Collections.reverse(elementi);
		
		for(String s : elementi) {
			System.out.println(s);
		}
		
	}

}
