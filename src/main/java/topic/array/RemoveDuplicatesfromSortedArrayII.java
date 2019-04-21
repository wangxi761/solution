package topic.array;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2) return nums.length;
		int second = 2, first = 2;
		while (second < nums.length) {
			if (nums[second] > nums[first - 2]) {
				nums[first] = nums[second];
				first++;
			}
			second++;

		}
		return first;
	}

	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int num : nums) {
			if (i < 2 || num > nums[i - 2])
				nums[i++] = num;
		}
		return i;
	}


}
