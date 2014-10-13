package hr.fer.zemris.java.tecaj_5;

public class Zaposlenik implements Comparable<Zaposlenik> {

	private String sifra;
	private String ime;
	private String prezime;
	private double placa;

	public Zaposlenik(String sifra, String ime, String prezime) {
		this(sifra, ime, prezime, 0.0);
	}

	public Zaposlenik(String sifra, String ime, String prezime, double placa) {
		super();
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.placa = placa;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getSifra() {
		return sifra;
	}

	public double getPlaca() {
		return placa;
	}

	public void setPlaca(double placa) {
		this.placa = placa;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Zaposlenik)){
			return false;
		}
		Zaposlenik drugi = (Zaposlenik)obj;
		return this.getSifra().equals(drugi.getSifra());
	}
	
	@Override
	public int hashCode() {		
		return this.getSifra().hashCode();
	}
	
	@Override
	public int compareTo(Zaposlenik o) {		
		//System.out.println("Usporedi("+this+" s "+o+")");
		return this.getSifra().compareTo(o.getSifra());
	}

	@Override
	public String toString() {
		return String.format("Zaposlenik=: sifra= %s, \time=%s, \tprezime=%s, \tplaca=%f", 
				sifra, ime, prezime, placa);
		/*
		 * return "Zaposlenik=: sifra=" + sifra + ", ime=" + ime + ", prezime="
		 * + prezime + ", placa=" + placa;
		 */
	}

}
