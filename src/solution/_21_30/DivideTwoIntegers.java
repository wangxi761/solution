package solution._21_30;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivideTwoIntegers {
	public int divideI(int dividend, int divisor) {
		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
			return Integer.MAX_VALUE;
		if (divisor == 1)
			return dividend;
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		int count = 0;
		while (a > 0) {
			a -= b;
			count++;
		}
		if (a != 0)
			count--;
		return count * sign;
	}

	public int divide(int dividend, int divisor) {
		if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
			return Integer.MAX_VALUE;
		if (divisor == 1)
			return dividend;
		int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
		long a = Math.abs((long) dividend);
		long b = Math.abs((long) divisor);
		long t = b;
		while (a > b) {
			b = b << 1;
			if (a > b)
				break;
		}
		System.out.println(b);
		return 0;
	}

	@Test
	public void test() throws Exception {
		assertEquals(3, divide(10, 3));
	}
}
