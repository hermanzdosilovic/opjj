package hr.fer.zemris.java.tecaj4;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class IspisBezDuplikata {

	public static void main(String[] args) {
		System.out.println("Prvi pokušaj:\n------------------");
		ispisi(ukloni1(args));
		
		System.out.println("Drugi pokušaj:\n------------------");
		ispisi(ukloni2(args));
		
		System.out.println("Treci pokušaj:\n------------------");
		ispisi(ukloni3(args));
		
	}
	
	public static void ispisi(Collection<String> kolekcija) {
		for(String s: kolekcija) {
			System.out.println(s);
		}
	}
	
	public static Collection<String> ukloni1(String[] args) {
		return napuniSkup(args, new  HashSet<String>());
	}

	public static Collection<String> ukloni2(String[] args) {
		return napuniSkup(args, new  TreeSet<String>());
	}
	
	public static Collection<String> ukloni3(String[] args) {
		return napuniSkup(args, new  LinkedHashSet<String>());
	}
	
	public static Set<String> napuniSkup(String[] args, Set<String> set) {
		for(String s : args) {
			set.add(s);
		}
		return set;
	}
}
