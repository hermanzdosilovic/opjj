package hr.fer.zemris.java.tecaj_9;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Prozor1 extends JFrame {

	private static final long serialVersionUID = 1L;

	public Prozor1() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(500, 500);
		getContentPane().setLayout(new BorderLayout());
		
		MyCanvas canvas = new MyCanvas(new String[]{"Ovo je tekst.", "Još jedan redak.", "Još jedan."});
		canvas.setBorder(BorderFactory.createLineBorder(Color.GREEN, 10));
		
		getContentPane().add(canvas, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Prozor1().setVisible(true);
			}
		});
	}

}
