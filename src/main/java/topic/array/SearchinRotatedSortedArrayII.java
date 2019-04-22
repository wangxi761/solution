package topic.array;

public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] > target) {

			}
		}

		return true;
	}
}
