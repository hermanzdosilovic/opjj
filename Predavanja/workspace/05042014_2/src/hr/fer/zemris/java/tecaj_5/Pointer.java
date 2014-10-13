package hr.fer.zemris.java.tecaj_5;

public class Pointer<T> {
	
	private T value;
	
	public <X extends T> Pointer(X value){
		this.value = value;
	}

	public T getValue() {
		return value;
	}
	
	public <X extends T> void setValue(X value) {
		this.value = value;
	}
	
}
