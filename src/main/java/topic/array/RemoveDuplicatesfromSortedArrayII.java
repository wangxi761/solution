package topic.array;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates1(int[] nums) {
		if (nums.length <= 2) return nums.length;
		int cur = 1, pre = 0, count = 1;
		while (cur < nums.length) {
			if (nums[pre] == nums[cur]) {
				if (count == 1)
					count++;
				if (count == 2) {
					count = 1;
					cur++;
				}

			} else {
				nums[cur] = nums[pre] + 1;
				pre = cur;
			}
		}
		return pre;
	}

	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int num : nums) {
			if (i < 2 || num > nums[i - 2])
				nums[i++] = num;
		}
		return i;
	}


}
