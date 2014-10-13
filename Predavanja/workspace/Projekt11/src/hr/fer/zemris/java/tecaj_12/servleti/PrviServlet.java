package hr.fer.zemris.java.tecaj_12.servleti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ovo je jedan IWebWorker
@SuppressWarnings("serial")
public class PrviServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Hello, World!</h1>");
		writer.println("<p>Ovo je naš prvi servlet.</p>");
		writer.println("<p><img src='slika'/></p>");
		writer.println("<p><img src='slika?poruka=Pozdravi'/></p>");
		writer.println("<p><img src='slika?poruka=Dva%20dijela'/></p>");
	}
}
