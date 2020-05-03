package study.dp;

import org.junit.jupiter.api.Test;

public class Fibonacci {

	public int fib(int n) {
		if (n == 1)
			return 1;
		else if (n == 2)
			return 1;
		else
			return fib(n - 2) + fib(n - 1);
	}
	@Test
	public void test() throws Exception {
		System.out.println(fib(6));
	}
}
