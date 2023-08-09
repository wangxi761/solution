package leetcode.problems._2601_2700.Minimize_the_Maximum_Difference_of_Pairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int minimizeMax(int[] nums, int p) {
		Map<Integer, Integer> counts = new HashMap<>();
		for (int num : nums) {
			Integer count = counts.getOrDefault(num, 0);
			if(count==1)
			counts.put(num, count + 1);
		}
		return 1;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums = [10,1,2,7,1,3], p = 2
		//Output: 1
		//Explanation: The first pair is formed from the indices 1 and 4, and the second pair is formed from the indices 2 and 5.
		//The maximum difference is max(|nums[1] - nums[4]|, |nums[2] - nums[5]|) = max(0, 1) = 1. Therefore, we return 1.
		
		//Example 2:
		//
		//Input: nums = [4,2,1,2], p = 1
		//Output: 0
		//Explanation: Let the indices 1 and 3 form a pair. The difference of that pair is |2 - 2| = 0, which is the minimum we can attain.
		
		Assertions.assertEquals(1, minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 2));
		Assertions.assertEquals(0, minimizeMax(new int[]{4, 2, 1, 2}, 1));
	}
}