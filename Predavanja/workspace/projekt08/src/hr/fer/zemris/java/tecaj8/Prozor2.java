package hr.fer.zemris.java.tecaj8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Prozor2 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static String[] poruke = new String[] {
		"Ovo je prva poruka",
		"Ovo je druga poruka", 
		"Ovo je treća poruka",
		"Ovo je četvrta poruka"
	};
	
	public Prozor2() {
		initGUI();
		pack();
	}

	private void initGUI() {
		setLocation(200, 100);
		setSize(300, 250);
		setTitle("Naš prvi Java prozor!");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		getContentPane().setLayout(new BorderLayout(2, 2));

		final JLabel labela = new JLabel(
				"<html><h1>Pozdrav iz Jave</h1><p>Evo još <b>jednog</b> retka</p></html>");
		JButton gumb = new JButton("Stisni me!");

		JButton gumb1 = new JButton("Stisni me 1");
		JButton gumb2 = new JButton("Stisni me 2");
		JButton gumb3 = new JButton("Stisni me 3");
		final JButton gumb4 = new JButton("Stisni me 4");
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1, 4, 2, 0));
		

		gumb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				labela.setText("0");
			}
		});
		gumb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int broj;
				try
				{
					broj = Integer.parseInt(labela.getText());
					broj += 5;
					labela.setText(String.valueOf(broj));
				} catch(NumberFormatException asdf) {
					JOptionPane.showMessageDialog(Prozor2.this, "Dragi korisniče, xyz|#|#|", "Pogreška", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		gumb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel vanjski = new JPanel(new BorderLayout());
				JPanel lijevi = new JPanel(new GridLayout(2, 1, 0, 3));
				JPanel desni = new JPanel(new GridLayout(2, 1, 0, 3));
				lijevi.add(new JLabel("Username"));
				lijevi.add(new JLabel("Password"));
				JTextField username = new JTextField();
				JPasswordField password = new JPasswordField();
				desni.add(username);
				desni.add(password);
				vanjski.add(lijevi, BorderLayout.LINE_START);
				vanjski.add(desni, BorderLayout.CENTER);
				
				int rez = JOptionPane.showConfirmDialog(Prozor2.this, vanjski, "Potrebna autorizacija", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
				if(rez == JOptionPane.OK_OPTION) {
					String poruka = username.getText() + "/" + password.getText();
					JOptionPane.showMessageDialog(Prozor2.this, poruka);
				}
			}
		});
		gumb4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					final AtomicBoolean zastavica = new AtomicBoolean(false);
					Thread radnik = new Thread() {
					@Override
					public void run() {
						int brojac = 0;
						while(true) {
							prikaziPoruku(brojac);
							try
							{
								Thread.sleep(2000);
							} catch(Exception ignorable) {}
							brojac++;
							if(brojac >= poruke.length)
								brojac = 0;
							
						}
					}

					private void prikaziPoruku(int brojac) {
						final String poruka = poruke[brojac];
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								labela.setText(poruka);
							}
							
						});
					}
				};
				radnik.start();
				gumb4.setEnabled(false);
				addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						zastavica.set(true);
					}
				});
			}
		});
		p.add(gumb1);
		p.add(gumb2);
		p.add(gumb3);
		p.add(gumb4);
		getContentPane().add(labela, BorderLayout.NORTH);
		// getContentPane().add(gumb, BorderLayout.CENTER);
		getContentPane().add(p);
		// labela.setLocation(20, 20);
		labela.setForeground(Color.RED);
		// labela.setBackground(Color.BLUE);
		// labela.setOpaque(true);

		// Ovo će biti ignorirano
		// labela.setSize(labela.getPreferredSize());
		// gumb.setSize(gumb.getPreferredSize());
		//
		labela.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5));
		// gumb.setLocation(20, labela.getLocation().y + labela.getHeight() +
		// 20);

	}

	public static void main(String[] args) {
		System.out.println("Bok!");
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Prozor2().setVisible(true);

			}
		});
	}
}
