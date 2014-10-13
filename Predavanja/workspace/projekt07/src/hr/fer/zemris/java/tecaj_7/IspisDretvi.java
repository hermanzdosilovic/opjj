package hr.fer.zemris.java.tecaj_7;

public class IspisDretvi {

	public static void main(String[] args) {
		
		Thread trenutna = Thread.currentThread();
		
		System.out.println("Ovaj kod izvod dretva imena: " + trenutna.getName());
		
		ThreadGroup grupa = trenutna.getThreadGroup();
		
		while(grupa.getParent() != null) {
			grupa = grupa.getParent();
		}
		
		grupa.list();
	}

}
