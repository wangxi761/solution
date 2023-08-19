package leetcode.problems._001_100._4sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > target && target > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				long ij = nums[i] + nums[j];
				if (ij > target && target > 0) {
					break;
				}
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1, right = nums.length - 1;
				while (left < right) {
					long sum = ij + nums[left] + nums[right];
					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else {
						res.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right + 1]) {
							right--;
						}
					}
				}
			}
		}
		return res;
	}
	
	@Test
	public void test() {
		List<List<Integer>> lists = fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
		//Example 1:
		//
		//Input: nums = [1,0,-1,0,-2,2], target = 0
		//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
		Assertions.assertEquals(List.of(List.of(-2, -1, 1, 2), List.of(-2, 0, 0, 2), List.of(-1, 0, 0, 1)), fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
		
		//Example 2:
		//
		//Input: nums = [2,2,2,2,2], target = 8
		//Output: [[2,2,2,2]]
		Assertions.assertEquals(List.of(List.of(2, 2, 2, 2)), fourSum(new int[]{2, 2, 2, 2, 2}, 8));
	}
}