package topic.memoization;

public class FibonacciNumber {
	public int fib(int n) {
		if (n < 2) {
			return n;
		}
		int a = 0, b = 1, res = 0;
		for (int i = 1; i < n; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
}
