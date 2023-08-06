package leetcode.problems._201_300.Minimum_Size_Subarray_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int min = Integer.MAX_VALUE;
		int l = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= target) {
				min = Math.min(min, i - l + 1);
				sum -= nums[l++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: target = 7, nums = [2,3,1,2,4,3]
		//Output: 2
		//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
		//Example 2:
		//
		//Input: target = 4, nums = [1,4,4]
		//Output: 1
		//Example 3:
		//
		//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
		//Output: 0
		Assertions.assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
		Assertions.assertEquals(1, minSubArrayLen(4, new int[]{1, 4, 4}));
		Assertions.assertEquals(0, minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
	}
}