package hr.fer.zemris.java.tecaj_7;

public class PokretanjeDretveParalelno3 {

	private volatile static int brojac = 0;

	public static void main(String[] args) throws Exception {
		System.out.println("Pocetno brojac je: " + brojac);
		Object kontroler = new Object();

		PosaoDretve posao = new PosaoDretve(1_000_000, kontroler);

		final int brojDretvi = 5;
		Thread[] radnici = new Thread[brojDretvi];
		for (int i = 0; i < brojDretvi; i++) {
			radnici[i] = new Thread(posao, "Radnik" + i);
		}
		for (int i = 0; i < brojDretvi; i++) {
			radnici[i].start();
		}
		for (int i = 0; i < brojDretvi; i++) {
			radnici[i].join();
		}
		System.out.println("Konacno stanje brojaca je: " + brojac);
	}

	public static class PosaoDretve implements Runnable {

		private int brojUvecavanja;
		private Object kontroler;

		public PosaoDretve(int brojUvecavanja, Object kontroler) {
			this.brojUvecavanja = brojUvecavanja;
			this.kontroler = kontroler;
		}

		@Override
		public void run() {
			synchronized (kontroler) {
				for (int i = 0; i < brojUvecavanja; i++) {
					brojac++;
				}
			}
		}
	}
}
