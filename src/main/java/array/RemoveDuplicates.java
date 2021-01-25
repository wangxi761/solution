package array;

import java.util.Arrays;

public class RemoveDuplicates {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}
		int i = 0, j = 1;
		while (i < nums.length && j < nums.length) {
			while (i < nums.length && j < nums.length && nums[i] < nums[j]) {
				i++;
				j++;
			}
			int p = j;
			while (p < nums.length && nums[i] >= nums[p]) {
				p++;
			}
			if (p >= nums.length) break;
			swap(nums, j, p);
			i++;
			j++;
		}
		return i + 1;
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		int[] nums = {1, 2};
		int i = removeDuplicates.removeDuplicates(nums);
		System.out.println(i);
		System.out.println(Arrays.toString(nums));
	}
}
