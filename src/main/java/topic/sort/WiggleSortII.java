package topic.sort;

import java.util.Arrays;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int[] res = new int[nums.length];
		int i = 1;
		for (int j = nums.length - 1; j >= 0; j--) {
			if (i >= nums.length) i = 0;
			res[i] = nums[j];
			i += 2;
		}
		System.arraycopy(res, 0, nums, 0, nums.length);
	}
}
