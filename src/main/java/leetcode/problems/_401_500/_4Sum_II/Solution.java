package leetcode.problems._401_500._4Sum_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) {
			for (int j : nums2) {
				map.put(i + j, map.getOrDefault(i + j, 0) + 1);
			}
		}
		int count = 0;
		for (int i : nums3) {
			for (int j : nums4) {
				if (map.containsKey(-i - j)) {
					count += map.get(-i - j);
				}
			}
		}
		return count;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
		//Output: 2
		//Explanation:
		//The two tuples are:
		//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
		//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
		//Example 2:
		//
		//Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
		//Output: 1
		Assertions.assertEquals(2, fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
		Assertions.assertEquals(1, fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
	}
}