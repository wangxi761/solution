package solution._2501_2600.Put_Marbles_in_Bags;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
	public long putMarbles(int[] weights, int k) {
		int n = weights.length - 1;
		long[] sum = new long[n];
		long res = 0;
		for (int i = 0; i < sum.length; i++) {
			sum[i] = weights[i] + weights[i + 1];
		}
		Arrays.sort(sum);
		for (int i = 0; i < k - 1; i++) {
			res += sum[n - 1 - i] - sum[i];
		}
		return res;
	}
	
	@Test
	public void test() {
		// Input: weights = [1,3,5,1], k = 2
		// Output: 4
		Assertions.assertEquals(4, putMarbles(new int[]{1, 3, 5, 1}, 2));
		
		// Input: weights = [1, 3], k = 2
		//Output: 0
		Assertions.assertEquals(0, putMarbles(new int[]{1, 3}, 2));
	}
}