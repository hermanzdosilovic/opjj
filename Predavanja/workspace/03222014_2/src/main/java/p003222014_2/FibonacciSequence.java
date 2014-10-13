package p003222014_2;

public class FibonacciSequence {
	
	public static int getElement(int index) {
		if(index < 0) throw new IllegalArgumentException("Sekvenca nije definirana za negativne indekse. Dobio sam index: " + index);
		if(index >= 0 && index <= 1) return index;
		return getElement(index - 1) + getElement(index - 2);
	}
}
