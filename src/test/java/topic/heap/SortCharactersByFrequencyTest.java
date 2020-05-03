package topic.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortCharactersByFrequencyTest {
	SortCharactersByFrequency test = new SortCharactersByFrequency();
	
	@Test
	public void frequencySort() {
		assertEquals("bbAa", test.frequencySort("Aabb"));
	}
}