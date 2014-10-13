package hr.fer.zemris.strategija;

public interface ObradaDatoteke<T> {

	void staviPodatak(String[] elems);
	int dohvatiOcekivaniBrojStupaca();
	T dohvatiKolekciju();
	
}
