package study.RecursionII;

public class SortAnArray {
	public int[] sortArray(int[] nums) {
		recursive(nums, 0, nums.length - 1);
		return nums;
	}
	
	public void recursive(int[] nums, int begin, int end) {
		if (end - begin == 0) {
			return;
		} else if (end - begin == 1) {
			if (nums[end] < nums[begin]) {
				swap(nums, begin, end);
			}
			return;
		} else {
			recursive(nums, begin, (begin + end) / 2);
			recursive(nums, (begin + end) / 2 + 1, end);
			mergeInPlace(nums, begin, (begin + end) / 2, end);
		}
	}
	
	public void mergeInPlace(int[] nums, int i, int j, int k) {
		if (i > j || i >= k || j >= k) {
			return;
		}
		int mid = j;
		while (i < k && nums[i] <= nums[j + 1]) {
			i++;
		}
		while (j < k && nums[j + 1] < nums[i]) {
			j++;
		}
		swapBlock(nums, i, mid, j);
		mergeInPlace(nums, j - mid + i, j, k);
	}
	
	public void swapBlock(int[] nums, int i, int j, int k) {
		reverse(nums, i, j);
		reverse(nums, j + 1, k);
		reverse(nums, i, k);
	}
	
	
	public void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
