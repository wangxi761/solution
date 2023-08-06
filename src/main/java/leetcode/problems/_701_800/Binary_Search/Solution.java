package leetcode.problems._701_800.Binary_Search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public int searchI(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (target < nums[mid]) {
				r = mid - 1;
			} else if (target > nums[mid]) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] > target) {
				r = mid;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums = [-1,0,3,5,9,12], target = 9
		//Output: 4
		//Explanation: 9 exists in nums and its index is 4
		//Example 2:
		//
		//Input: nums = [-1,0,3,5,9,12], target = 2
		//Output: -1
		//Explanation: 2 does not exist in nums so return -1
		Assertions.assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
		Assertions.assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
		
	}
}