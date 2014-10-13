package hr.fer.zemris.java.tecaj_8.fraktali;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RecursiveAction;

import hr.fer.zemris.java.tecaj_06.fractals.FractalViewer;
import hr.fer.zemris.java.tecaj_06.fractals.IFractalProducer;
import hr.fer.zemris.java.tecaj_06.fractals.IFractalResultObserver;

public class FraktalParalelno4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FractalViewer.show(new MojProducer());	
	}

	public static class PosaoIzracuna extends RecursiveAction {
		double reMin;
		double reMax;
		double imMin;
		double imMax;
		int width;
		int height;
		int yMin;
		int yMax;
		int m;
		short[] data;
		static final int treshold = 16;
		
		public PosaoIzracuna(double reMin, double reMax, double imMin,
				double imMax, int width, int height, int yMin, int yMax, 
				int m, short[] data) {
			super();
			this.reMin = reMin;
			this.reMax = reMax;
			this.imMin = imMin;
			this.imMax = imMax;
			this.width = width;
			this.height = height;
			this.yMin = yMin;
			this.yMax = yMax;
			this.m = m;
			this.data = data;
		}

		public void compute() {
			if(yMax-yMin+1 <= treshold) {
				computeDirect();
				return;
			}
			invokeAll(
				new PosaoIzracuna(reMin, reMax, imMin, imMax, width, height, yMin, yMin+(yMax-yMin)/2, m, data),
				new PosaoIzracuna(reMin, reMax, imMin, imMax, width, height, yMin+(yMax-yMin)/2+1, yMax, m, data)
			);
		}

		public void computeDirect() {
			System.out.println("Racunam od "+yMin+" do "+yMax);
			int offset = yMin * width;
			for(int y = yMin; y <= yMax; y++) {
				for(int x = 0; x < width; x++) {
					double cre = x / (width-1.0) * (reMax - reMin) + reMin;
					double cim = (height-1.0-y) / (height-1) * (imMax - imMin) + imMin;
					double zre = 0;
					double zim = 0;
					double module = 0;
					int iters = 0;
					do {
						double zn1re = zre*zre - zim*zim + cre;
						double zn1im = 2*zre*zim +cim;
						module = zn1re*zn1re + zn1im*zn1im;
						zre = zn1re;
						zim = zn1im;
						iters++;
					} while(iters < m && module < 4.0);
					data[offset] = (short)iters;
					offset++;
				}
			}
		}
	}
	
	
	public static class MojProducer implements IFractalProducer {
		@Override
		public void produce(double reMin, double reMax, double imMin, double imMax,
				int width, int height, long requestNo, IFractalResultObserver observer) {
			System.out.println("Zapocinjem izracun...");
			int m = 16*16*16;
			short[] data = new short[width * height];

			ForkJoinPool pool = new ForkJoinPool();
			pool.invoke(new PosaoIzracuna(reMin, reMax, imMin, imMax, width, height, 0, height-1, m, data));
			pool.shutdown();
			
			System.out.println("Racunanje gotovo. Idem obavijestiti promatraca tj. GUI!");
			observer.acceptResult(data, (short)m, requestNo);
		}
	}
}
