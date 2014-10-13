package hr.fer.zemris.java.tecaj8;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Prozor1 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Prozor1() {
		initGUI();
	}
	
	private void initGUI() {
		setLocation(200, 100);
		setSize(300, 250);
		setTitle("Naš prvi Java prozor!");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
		JLabel labela = new JLabel("<html><h1>Pozdrav</h1><p>Evo još <b>jednog</b> retka</p></html>");
		JButton gumb = new JButton("Stisni me!");
		
		getContentPane().add(labela);
		getContentPane().add(gumb);
		
		labela.setLocation(20, 20);
		//labela.setForeground(Color.RED);
		//labela.setBackground(Color.BLUE);
		//labela.setOpaque(true);
		
		
		labela.setSize(labela.getPreferredSize());
		gumb.setSize(gumb.getPreferredSize());
		
		labela.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
		gumb.setLocation(20, labela.getLocation().y + labela.getHeight() + 20);
		
	}
	
	public static void main(String[] args) {
		System.out.println("Bok!");
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Prozor1().setVisible(true);
				
			}
		});
	}
}
