package topic.backtracking;

import org.junit.jupiter.api.Test;

public class CombinationSumTest {
	topic.backtracking.CombinationSum test = new topic.backtracking.CombinationSum();
	
	@Test
	public void combinationSum() {
		test.combinationSum(new int[]{2, 3, 5}, 8).forEach(System.out::println);
	}
}