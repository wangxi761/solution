package leetcode.problems._001_100.Search_in_Rotated_Sorted_Array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] >= nums[left]) {
				if (nums[mid] > target && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target <= nums[right] && target > nums[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums = [4,5,6,7,0,1,2], target = 0
		//Output: 4
		//Example 2:
		//
		//Input: nums = [4,5,6,7,0,1,2], target = 3
		//Output: -1
		//Example 3:
		//
		//Input: nums = [1], target = 0
		//Output: -1
		Assertions.assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
		Assertions.assertEquals(-1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
		Assertions.assertEquals(-1, search(new int[]{1}, 0));
	}
}

