package topic.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberComplementTest {
	NumberComplement test = new NumberComplement();
	
	@Test
	public void findComplement() {
		assertEquals(2, test.findComplement(5));
		assertEquals(0, test.findComplement(7));
	}
	
}