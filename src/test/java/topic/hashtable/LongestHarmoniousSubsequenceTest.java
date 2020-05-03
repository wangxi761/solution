package topic.hashtable;

import org.junit.jupiter.api.Test;

public class LongestHarmoniousSubsequenceTest {
	LongestHarmoniousSubsequence test = new LongestHarmoniousSubsequence();
	
	@Test
	public void findLHS() {
		System.out.println(test.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
	}
}