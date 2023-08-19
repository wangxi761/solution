package leetcode.problems._001_100.Two_Sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> cache = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (cache.containsKey(target - num)) {
				return new int[]{cache.get(target - num), i};
			}
			cache.put(num, i);
		}
		return new int[]{};
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums = [2,7,11,15], target = 9
		//Output: [0,1]
		//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
		//Example 2:
		//
		//Input: nums = [3,2,4], target = 6
		//Output: [1,2]
		//Example 3:
		//
		//Input: nums = [3,3], target = 6
		//Output: [0,1]
		
		int[] actual = twoSum(new int[]{2, 7, 11, 15}, 9);
		Arrays.sort(actual);
		Assertions.assertArrayEquals(new int[]{0, 1}, actual);
		
		actual = twoSum(new int[]{3, 2, 4}, 6);
		Arrays.sort(actual);
		Assertions.assertArrayEquals(new int[]{1, 2}, actual);
		
		actual = twoSum(new int[]{3, 3}, 6);
		Arrays.sort(actual);
		Assertions.assertArrayEquals(new int[]{0, 1}, actual);
	}
}