package topic.array;

public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1, mid = -1;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] > nums[hi] || nums[mid] > nums[lo]) {
				if (target < nums[mid] && target >= nums[lo])
					hi = mid - 1;
				else
					lo = mid + 1;
			} else if (nums[mid] < nums[hi] || nums[mid] < nums[lo]) {
				if (target > nums[mid] && target <= nums[hi])
					lo = mid + 1;
				else
					hi = mid - 1;
			} else {
				hi--;
			}
		}
		return false;
	}
}
