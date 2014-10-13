package hr.fer.zemris.java.tecaj_5;

public class Zaposlenik implements Comparable<Zaposlenik>{

	private String sifra;
	private String ime;
	private String prezime;
	private double placa;

	public Zaposlenik(String sifra, String ime, String prezime, double placa) {
		super();
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.placa = placa;
	}

	public Zaposlenik(String sifra, String ime, String prezime) {
		this(sifra, ime, prezime, 0);
	}

	public double getPlaca() {
		return placa;
	}

	public void setPlaca(double placa) {
		this.placa = placa;
	}

	public String getSifra() {
		return sifra;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	@Override
	public String toString() {
		return "Zaposlenik: sifra=" + sifra + ", ime=" + ime + ", prezime="
				+ prezime + ", placa=" + placa;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (!(obj instanceof Zaposlenik)) {
//			return false;
//		}
//
//		Zaposlenik drugi = (Zaposlenik) obj;
//		return this.getSifra().equals(drugi.getSifra());
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		result = prime * result + ((sifra == null) ? 0 : sifra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zaposlenik other = (Zaposlenik) obj;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}

	@Override
	public int compareTo(Zaposlenik o) {
		return getSifra().compareTo(o.getSifra());
	}
	
//	@Override
//	public int hashCode() {
//		return this.getSifra().hashCode();
//	}
}
