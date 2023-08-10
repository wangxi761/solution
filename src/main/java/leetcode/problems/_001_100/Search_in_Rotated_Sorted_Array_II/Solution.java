package leetcode.problems._001_100.Search_in_Rotated_Sorted_Array_II;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {
	public boolean search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] < nums[left] || nums[mid] < nums[right]) {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
				if (target < nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				right--;
			}
		}
		return false;
	}
	
	@Test
	public void test() {
		//Example 1:
		//
		//Input: nums = [2,5,6,0,0,1,2], target = 0
		//Output: true
		
		//Example 2:
		//
		//Input: nums = [2,5,6,0,0,1,2], target = 3
		//Output: false
		//
		//Constraints:
		//1 <= nums.length <= 5000
		//-104 <= nums[i] <= 104
		//nums is guaranteed to be rotated at some pivot.
		//-104 <= target <= 104
		
		Assertions.assertTrue(search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 13));
		Assertions.assertTrue(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
		Assertions.assertFalse(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
	}
}