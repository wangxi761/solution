package study.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciNumberTest {
	FibonacciNumber test = new FibonacciNumber();
	
	@Test
	public void fib() {
		assertEquals(3, test.fib(4));
	}
}