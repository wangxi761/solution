package topic.memoization;

import org.junit.jupiter.api.Test;

public class NthTribonacciNumber {
	public int tribonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1 || n == 2) {
			return 1;
		}
		int a = 0, b = 1, c = 1;
		for (int i = 3; i <= n; i++) {
			int sum = a + b + c;
			a = b;
			b = c;
			c = sum;
		}
		return c;
	}
	
	@Test
	public void test() {
		assert 4 == tribonacci(4);
		assert 1389537 == tribonacci(25);
	}
}
