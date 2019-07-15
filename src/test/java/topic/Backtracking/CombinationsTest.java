package topic.backtracking;

import org.junit.Test;

public class CombinationsTest {
	Combinations test = new Combinations();
	
	@Test
	public void combine() {
		test.combine(4, 2).forEach(System.out::println);
	}
}