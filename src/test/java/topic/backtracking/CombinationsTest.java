package topic.Backtracking;

import org.junit.jupiter.api.Test;

public class CombinationsTest {
	topic.backtracking.Combinations test = new topic.backtracking.Combinations();
	
	@Test
	public void combine() {
		test.combine(4, 2).forEach(System.out::println);
	}
}