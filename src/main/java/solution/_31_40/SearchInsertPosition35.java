package solution._31_40;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInsertPosition35 {

	public int searchInsert(int[] nums, int target) {
		int lo = 0, hi = nums.length-1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target) {
				hi = mid-1;
			} else if (nums[mid] < target) {
				lo = mid+1;
			}
		}
		return lo;
	}

	@Test
	public void test() throws Exception {
		int[] arr = { 1,3,5,7,9 };
		System.out.println(searchInsert(arr, 4));
	}
}
