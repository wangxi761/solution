package topic.memoization;

import org.junit.jupiter.api.Test;

public class ClimbingStairs {
	
	public int climbStairs(int n) {
		if (n < 3) {
			return n;
		}
		int a = 1, b = 2, res = 0;
		for (int i = 2; i < n; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
	
	@Test
	public void test() {
		assert climbStairs(2) == 2;
		assert climbStairs(3) == 3;
		assert climbStairs(3) == 3;
	}
}
