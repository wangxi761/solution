package topic.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortCharactersByFrequencyTest {
	SortCharactersByFrequency test = new SortCharactersByFrequency();
	
	@Test
	public void frequencySort() {
		assertEquals("bbAa", test.frequencySort("Aabb"));
	}
}