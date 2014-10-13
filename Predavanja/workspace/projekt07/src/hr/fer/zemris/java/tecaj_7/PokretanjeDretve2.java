package hr.fer.zemris.java.tecaj_7;

public class PokretanjeDretve2 {

	public static void main(String[] args) {

		Runnable posao = new Runnable() {
			@Override
			public void run() {
				System.out.println("Pozdravi iz dretve: "
						+ Thread.currentThread().getName());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException ignorable) {
				}
				System.out.println("Pomocna dretva završava posao i umire.");
			}
		};
		
		Thread t = new Thread(posao);
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignorable) {
		}
		System.out.println("Glavna dretva umire.");
	}
}
