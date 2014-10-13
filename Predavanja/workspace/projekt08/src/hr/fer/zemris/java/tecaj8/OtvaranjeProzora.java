package hr.fer.zemris.java.tecaj8;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class OtvaranjeProzora {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				final JFrame f = new JFrame();
				f.setLocation(200, 100);
				f.setSize(300, 250);
				f.setTitle("Naš prvi Java prozor!");
				f.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				
				System.out.println(Thread.currentThread().getName());
				
				f.addWindowListener(new WindowListener() {
					
					@Override
					public void windowOpened(WindowEvent e) {
						System.out.println("Ja se otvaram!");
						System.out.println(Thread.currentThread().getName());
					}
					
					@Override
					public void windowIconified(WindowEvent e) {
					}
					
					@Override
					public void windowDeiconified(WindowEvent e) {
					}
					
					@Override
					public void windowDeactivated(WindowEvent e) {
					}
					
					@Override
					public void windowClosing(WindowEvent e) {
						System.out.println("Hoće me se zatvoriti!");
						System.out.println(Thread.currentThread().getName());
						// ...
//						e.getWindow().dispose();
						f.dispose();
					}
					
					@Override
					public void windowClosed(WindowEvent e) {
						System.out.println("Ja sam zatvoren!");
					}
					
					@Override
					public void windowActivated(WindowEvent e) {
					}
				});
				
				f.setVisible(true);
			}
			
		});
		
		
		// ------------------------------------------------------------------------------
		
		Thread trenutna = Thread.currentThread();

		System.out
				.println("Ovaj kod izvod dretva imena: " + trenutna.getName());

		ThreadGroup grupa = trenutna.getThreadGroup();

		while (grupa.getParent() != null) {
			grupa = grupa.getParent();
		}

		grupa.list();
	}

}
