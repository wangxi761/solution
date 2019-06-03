package study.recursion;

public class FibonacciNumber {
	public int fib3(int N) {
		if (N == 0) {
			return 0;
		} else if (N == 1) {
			return 1;
		} else {
			return fib3(N - 1) + fib3(N - 2);
		}
	}
	
	public int fib2(int N) {
		int[] dp = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			if (i == 0) {
				dp[i] = 0;
			} else if (i == 1) {
				dp[i] = 1;
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		return dp[N];
	}
	
	public int fib(int N) {
		if (N <= 1) {
			return N;
		}
		int a = 0, b = 1;
		while (N-- > 1) {
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
}