package solution._31_40;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int max = nums[nums.length - 1];
		int i = nums.length - 1;
		while (i >= 0 && nums[i] >= max) {
			max = nums[i];
			i--;
		}
		if (i < 0) {
			int start = 0, end = nums.length-1;
			reserve(nums, start, end);
			return;
		}
		int j = nums.length - 1;
		while (j >= 0 && nums[i] >= nums[j]) {
			j--;
		}
		swap(nums, i, j);
		reserve(nums, i + 1, nums.length - 1);
	}

	private void reserve(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	private void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}
	@Test
	public void test() throws Exception {
		int[] nums= {1};
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
