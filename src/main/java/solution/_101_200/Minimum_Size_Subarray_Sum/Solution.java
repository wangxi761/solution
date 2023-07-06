package solution._101_200.Minimum_Size_Subarray_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int l = 0, r = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while (l < nums.length && r < nums.length) {
			sum += nums[r];
			if (sum >= target) {
				min = Math.min(min, r - l + 1);
				sum -= nums[l];
				sum -= nums[r];
				l++;
			} else {
				r++;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(3, minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
		Assertions.assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
		Assertions.assertEquals(1, minSubArrayLen(4, new int[]{1, 4, 4}));
		Assertions.assertEquals(0, minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
	}
}

