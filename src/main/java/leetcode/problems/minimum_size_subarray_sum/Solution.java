package leetcode.problems.minimum_size_subarray_sum;

//   Example 1:
//
//   Input: target = 7, nums = [2,3,1,2,4,3]
//   Output: 2
//   Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//   Example 2:
//
//   Input: target = 4, nums = [1,4,4]
//   Output: 1
//   Example 3:
//
//   Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//   Output: 0
//
//
//   Constraints:
//
//       1 <= target <= 109
//       1 <= nums.length <= 105
//       1 <= nums[i] <= 104
//
//
//   Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int size = Integer.MAX_VALUE;
		int i = 0, sum = 0;
		for (int j = 0; j < nums.length; j++) {
			sum += nums[j];
			while (sum >= target) {
				size = Math.min(size, j - i + 1);
				sum -= nums[i++];
			}
		}
		return size == Integer.MAX_VALUE ? 0 : size;
	}
	
	
	@Test
	public void findsMinimumSubarrayLengthForTarget() {
		int target = 7;
		int[] nums = {2, 3, 1, 2, 4, 3};
		int expected = 2;
		Assertions.assertEquals(expected, minSubArrayLen(target, nums));
	}
	
	@Test
	public void handlesArrayWithSingleElementEqualToTarget() {
		int target = 4;
		int[] nums = {1, 4, 4};
		int expected = 1;
		Assertions.assertEquals(expected, minSubArrayLen(target, nums));
	}
	
	@Test
	public void returnsZeroWhenTargetIsGreaterThanSumOfArray() {
		int target = 11;
		int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
		int expected = 0;
		Assertions.assertEquals(expected, minSubArrayLen(target, nums));
	}
	
	@Test
	public void handlesArrayWithAllElementsEqualToTarget() {
		int target = 2;
		int[] nums = {2, 2, 2, 2};
		int expected = 1;
		Assertions.assertEquals(expected, minSubArrayLen(target, nums));
	}
	
	@Test
	public void handlesArrayWithAllElementsLessThanTarget() {
		int target = 10;
		int[] nums = {1, 2, 3, 4};
		int expected = 4;
		Assertions.assertEquals(expected, minSubArrayLen(target, nums));
	}
}