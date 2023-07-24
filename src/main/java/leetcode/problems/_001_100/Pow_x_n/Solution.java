package leetcode.problems._001_100.Pow_x_n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public double myPow(double x, int n) {
		return n >= 0 ? power(x, n) : 1 / power(x, -n);
	}
	
	public double power(double x, int n) {
		if (n == 0) return 1;
		double res = power(x, n / 2);
		if (n % 2 == 0) return res * res;
		else return res * res * x;
	}
	
	@Test
	public void test() {
		//Input: x = 2.00000, n = 10
		//Output: 1024.00000
		Assertions.assertEquals(1024d, myPow(2d, 10));
		
		//Input: x = 2.00000, n = -2
		//Output: 0.25000
		Assertions.assertEquals(0.25000d, myPow(2d, -2));
		
		//Input: x = 2.10000, n = 3
		//Output: 9.26100
		Assertions.assertTrue(Math.abs(9.26100d - myPow(2.1d, 3)) < 0.0001);
	}
}