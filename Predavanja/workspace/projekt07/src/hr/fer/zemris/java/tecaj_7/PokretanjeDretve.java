package hr.fer.zemris.java.tecaj_7;

public class PokretanjeDretve {
	
	private volatile static int brojac = 0;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Pocetno brojac je: " + brojac);
		PosaoDretve posao = new PosaoDretve(500_000_000);
		Thread radnik = new Thread(posao, "radnik");
		radnik.start();
		radnik.join();
		System.out.println("Konacno stanje brojaca je: " + brojac);
	}
	
	public static class PosaoDretve implements Runnable {
		
		private int brojUvecavanja;
		
		public PosaoDretve(int brojUvecavanja) {
			this.brojUvecavanja = brojUvecavanja;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < brojUvecavanja; i++) {
				brojac++;
			}
		}
	}
}
