package topic.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HIndexTest {
	HIndex test = new HIndex();
	
	@Test
	public void hIndex() {
		assertEquals(3, test.hIndex(new int[]{3, 0, 6, 1, 5}));
		assertEquals(1, test.hIndex(new int[]{3}));
		assertEquals(0, test.hIndex(new int[]{}));
		
	}
}