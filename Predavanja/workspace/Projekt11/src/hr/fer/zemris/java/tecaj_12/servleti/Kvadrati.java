package hr.fer.zemris.java.tecaj_12.servleti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kvadrati")
public class Kvadrati extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
		Integer a = null;
		Integer b = null;
		
		try {
			a = Integer.valueOf(req.getParameter("a"));
		} catch(Exception e) {
			a = 0;
		}
		
		try {
			b = Integer.valueOf(req.getParameter("b"));
		} catch(Exception e) {
			b = 20;
		}
		
		List<Par> podatci = new ArrayList<>();
		for(int i = a; i < b; i++) {
			podatci.add(new Par(i, i * i));
		}
		
		req.setAttribute("rezultati", podatci);
		req.getRequestDispatcher("/WEB-INF/pages/pogled.jsp").forward(req, resp);
		
	}
	
	public static class Par {
		int broj;
		int vrijednost;
		
		Par(int broj, int vrijednost) {
			this.broj = broj;
			this.vrijednost = vrijednost;
		}

		public int getBroj() {
			return broj;
		}

		public void setBroj(int broj) {
			this.broj = broj;
		}

		public int getVrijednost() {
			return vrijednost;
		}

		public void setVrijednost(int vrijednost) {
			this.vrijednost = vrijednost;
		}
		
		
	}
}
