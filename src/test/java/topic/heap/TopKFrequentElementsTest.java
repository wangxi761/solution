package topic.heap;

import org.junit.jupiter.api.Test;

public class TopKFrequentElementsTest {
	TopKFrequentElements test = new TopKFrequentElements();
	
	@Test
	public void topKFrequent2() {
		System.out.println(test.topKFrequent2(new int[]{1}, 1));
		System.out.println(test.topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2));
	}
}