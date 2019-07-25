package topic.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeNumberofSetBitsinBinaryRepresentationTest {
	PrimeNumberofSetBitsinBinaryRepresentation test = new PrimeNumberofSetBitsinBinaryRepresentation();
	
	@Test
	public void countPrimeSetBits() {
		assertEquals(21, test.countPrimeSetBits(567, 607));
		assertEquals(4, test.countPrimeSetBits(6, 10));
		assertEquals(5, test.countPrimeSetBits(10, 15));
	}
}