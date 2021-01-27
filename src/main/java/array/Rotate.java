package array;

import java.util.Arrays;

public class Rotate {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		if (k == 0) {
			return;
		}
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int store = nums[current];
			do {
				int next = (current + k) % nums.length;
				int target = nums[next];
				nums[next] = store;
				store = target;
				current = next;
				count++;
			} while (current != start);
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		Rotate rotate = new Rotate();
		rotate.rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}
}
