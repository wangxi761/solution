package topic.bitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SingleNumberIIITest {
	SingleNumberIII test = new SingleNumberIII();
	
	@Test
	public void singleNumber() {
		assertArrayEquals(new int[]{5, 3}, test.singleNumber(new int[]{1, 2, 1, 3, 2, 5}));
	}
}