package leetcode.problems.binary_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] > target) {
				r = mid - 1;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	
	@Test
	public void searchFindsTargetInMiddleOfArray() {
		int[] nums = {1, 2, 3, 4, 5};
		int target = 3;
		int expected = 2;
		Assertions.assertEquals(expected, search(nums, target));
	}
	
	@Test
	public void searchFindsTargetAtStartOfArray() {
		int[] nums = {1, 2, 3, 4, 5};
		int target = 1;
		int expected = 0;
		Assertions.assertEquals(expected, search(nums, target));
	}
	
	@Test
	public void searchFindsTargetAtEndOfArray() {
		int[] nums = {1, 2, 3, 4, 5};
		int target = 5;
		int expected = 4;
		Assertions.assertEquals(expected, search(nums, target));
	}
	
	@Test
	public void searchReturnsMinusOneWhenTargetNotInArray() {
		int[] nums = {1, 2, 3, 4, 5};
		int target = 6;
		int expected = -1;
		Assertions.assertEquals(expected, search(nums, target));
	}
	
	@Test
	public void searchHandlesEmptyArray() {
		int[] nums = {};
		int target = 1;
		int expected = -1;
		Assertions.assertEquals(expected, search(nums, target));
	}
}