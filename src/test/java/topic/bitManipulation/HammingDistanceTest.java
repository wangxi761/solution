package topic.bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HammingDistanceTest {
	HammingDistance test = new HammingDistance();
	
	@Test
	public void hammingDistance() {
		assertEquals(2, test.hammingDistance(1, 4));
		assertEquals(2, test.hammingDistance(0b110010, 0b011010));
	}
	
	@Test
	public void test() {
		System.out.println(2 >>> 1);
	}
	
}