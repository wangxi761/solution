package solution._31_40;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchinRotatedSortedArray {

	public int search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (hi + lo) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[lo] <= nums[mid]) {
				if (target >= nums[lo] && target < nums[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (target <= nums[hi] && target > nums[mid]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}

	@Test
	public void test() throws Exception {
		int[] nums = { 3, 4, 5, 6, 7, 0, 1, 2 };
		int target = 2;
		int search = search(nums, target);
		System.out.println(search);
	}

}
