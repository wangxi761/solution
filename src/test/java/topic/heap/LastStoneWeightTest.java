package topic.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LastStoneWeightTest {
	LastStoneWeight test = new LastStoneWeight();
	
	@Test
	public void lastStoneWeight() {
		assertEquals(2, test.lastStoneWeight(new int[]{2, 2}));
	}
}