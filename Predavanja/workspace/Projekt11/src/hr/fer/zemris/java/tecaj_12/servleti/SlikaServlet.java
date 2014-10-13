package hr.fer.zemris.java.tecaj_12.servleti;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SlikaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/gif");

		String poruka = req.getParameter("poruka");

		BufferedImage bim = new BufferedImage(300, 300, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = (Graphics2D) bim.getGraphics();
		g.setColor(Color.red);
		g.fillRect(0, 0, 300, 300);
		g.setColor(Color.blue);
		g.fillOval(0, 0, 300, 300);

		if (poruka != null && !poruka.isEmpty()) {
			g.setColor(Color.yellow);
			g.drawString(poruka, 0, g.getFontMetrics().getAscent());
		}
		g.dispose();
		ImageIO.write(bim, "gif", resp.getOutputStream());
	}
}
