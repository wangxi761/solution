package topic.backtracking;

import org.junit.Test;

public class CombinationSumTest {
	CombinationSum test = new CombinationSum();
	
	@Test
	public void combinationSum() {
		test.combinationSum(new int[]{2, 3, 5}, 8).forEach(System.out::println);
	}
}