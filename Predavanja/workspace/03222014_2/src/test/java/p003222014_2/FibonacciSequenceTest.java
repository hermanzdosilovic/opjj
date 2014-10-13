package p003222014_2;

import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciSequenceTest {
	
	@Test
	public void elementZeroisZero() {
		int index = 0;
		int value = FibonacciSequence.getElement(index);
		
		assertEquals("Nulnit element sekvence trebao bi biti 0.", 0, value);
		
	}
	
	@Test
	public void elementOneIsZero() {
		int index = 1;
		int value = FibonacciSequence.getElement(index);
		
		assertEquals("Prvi element sekvence trebao bi biti 1.", 1, value);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void provjeraNegativnogIndexa() {
		FibonacciSequence.getElement(-5);
	}
}
