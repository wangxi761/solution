package array;

import java.util.Arrays;

public class MoveZeroes {
	
	public void moveZeroes(int[] nums) {
		for (int j = 0, i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, i, j++);
			}
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		if (i == j) return;
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 0, 2, 1};
		MoveZeroes moveZeroes = new MoveZeroes();
		moveZeroes.moveZeroes(arr);
		System.out.println(Arrays.toString(arr));
	}
}
