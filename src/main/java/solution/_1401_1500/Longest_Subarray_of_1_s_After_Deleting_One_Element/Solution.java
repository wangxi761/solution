package solution._1401_1500.Longest_Subarray_of_1_s_After_Deleting_One_Element;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int longestSubarray(int[] nums) {
		List<int[]> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < nums.length && j < nums.length) {
			if (nums[i] == 0) {
				i++;
				j++;
				continue;
			}
			if (nums[j] != 1) {
				list.add(new int[]{i, j - 1});
				i = j;
			} else {
				j++;
				if (j == nums.length) {
					list.add(new int[]{i, j - 1});
				}
			}
		}
		if (list.size() == 1) {
			int len = list.get(0)[1] - list.get(0)[0];
			return len == nums.length - 1 ? len : len + 1;
		}
		int max = 0;
		for (int k = 0; k < list.size() - 1; k++) {
			if (list.get(k + 1)[0] - list.get(k)[1] != 2) {
				max = Math.max(max, Math.max(list.get(k + 1)[1] - list.get(k + 1)[0] + 1, list.get(k)[1] - list.get(k)[0] + 1));
				continue;
			}
			max = Math.max(max, list.get(k + 1)[1] - list.get(k)[0]);
		}
		return max;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(1, longestSubarray(new int[]{1, 0, 0, 1, 0}));
		Assertions.assertEquals(1, longestSubarray(new int[]{1, 0, 0, 0, 0}));
		Assertions.assertEquals(3, longestSubarray(new int[]{1, 1, 0, 1}));
		Assertions.assertEquals(5, longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
		Assertions.assertEquals(2, longestSubarray(new int[]{1, 1, 1}));
	}
}

