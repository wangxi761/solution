package study.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumberTest {
	FibonacciNumber test = new FibonacciNumber();
	
	@Test
	public void fib() {
		assertEquals(3, test.fib(4));
	}
}