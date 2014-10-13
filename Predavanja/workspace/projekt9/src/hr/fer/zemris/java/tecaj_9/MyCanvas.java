package hr.fer.zemris.java.tecaj_9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.JComponent;

public class MyCanvas extends JComponent {

	private static final long serialVersionUID = 1L;

	private String[] poruke;
	private static final int MARGIN_LEFT = 5;
	
	public MyCanvas(String[] poruke) {
		this.poruke = poruke;
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		Dimension dim = this.getSize();
		Insets ins = this.getInsets();

		g.setColor(Color.BLUE);
		
		g.fillRect(ins.left, ins.top,
				(int) (dim.getWidth() - ins.right - ins.left),
				(int) (dim.getHeight() - ins.bottom - ins.top));
		
		FontMetrics fm = g.getFontMetrics();
		int baseLineY = ins.top + fm.getAscent();
		
		boolean prviRedak = true;
		
		for(String poruka : poruke) {
			g.setColor(Color.ORANGE);
			g.drawString(poruka, ins.left + MARGIN_LEFT, baseLineY);
			
			if(prviRedak) {
				prviRedak = false;
				g.setColor(Color.GREEN);
				g.drawLine(ins.left + MARGIN_LEFT, baseLineY, ins.left + MARGIN_LEFT + fm.stringWidth(poruka), baseLineY);
			}
			baseLineY += (int)(1.3 * fm.getHeight() + 0.5);
		}
		
		final int r = 50;
		
		g.setColor(Color.YELLOW);
		g.fillOval(ins.left + MARGIN_LEFT, baseLineY, 2 * r, 2 * r);
		g.setColor(Color.RED);
		g.drawOval(ins.left + MARGIN_LEFT, baseLineY, 2 * r, 2 * r);
	}
}
