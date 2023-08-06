package leetcode.problems._901_1000.Squares_of_a_Sorted_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int[] sortedSquares(int[] nums) {
		int[] res = new int[nums.length];
		int l = 0, r = nums.length - 1;
		int i = res.length - 1;
		while (l <= r) {
			if (nums[l] * nums[l] >= nums[r] * nums[r]) {
				res[i] = nums[l] * nums[l];
				l++;
			} else {
				res[i] = nums[r] * nums[r];
				r--;
			}
			i--;
		}
		return res;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums = [-4,-1,0,3,10]
		//Output: [0,1,9,16,100]
		//Explanation: After squaring, the array becomes [16,1,0,9,100].
		//After sorting, it becomes [0,1,9,16,100].
		//Example 2:
		//
		//Input: nums = [-7,-3,2,3,11]
		//Output: [4,9,9,49,121]
		Assertions.assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
		Assertions.assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
	}
}

