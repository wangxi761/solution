package solution._1201_1300.Longest_Arithmetic_Subsequence_of_Given_Difference;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int longestSubsequenceI(int[] arr, int difference) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			int j = i, count = 0;
			int next = arr[i];
			while (j < arr.length) {
				if (arr[j++] == next) {
					count++;
					next = next + difference;
				}
			}
			max = Math.max(max, count);
		}
		return max;
	}
	
	public int longestSubsequence(int[] arr, int difference) {
		Map<Integer, Integer> dp = new HashMap<>();
		int max = 1;
		for (int i = 0; i < arr.length; i++) {
			if (dp.containsKey(arr[i] - difference)) {
				dp.put(arr[i], dp.get(arr[i] - difference) + 1);
			} else {
				dp.put(arr[i], 1);
			}
			max = Math.max(max, dp.get(arr[i]));
		}
		return max;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(4, longestSubsequence(new int[]{1, 2, 3, 4}, 1));
		Assertions.assertEquals(1, longestSubsequence(new int[]{1, 3, 5, 7}, 1));
		Assertions.assertEquals(4, longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
	}
}
