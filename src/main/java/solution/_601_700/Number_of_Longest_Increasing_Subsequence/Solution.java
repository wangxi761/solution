package solution._601_700.Number_of_Longest_Increasing_Subsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int findNumberOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int[] cnt = new int[nums.length];
		Arrays.fill(dp, 1);
		Arrays.fill(cnt, 1);
		
		int max = 0, res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[i] == dp[j] + 1) {
						cnt[i] += cnt[j];
					} else if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						cnt[i] = cnt[j];
					}
				}
			}
			if (max == dp[i]) {
				res += cnt[i];
			} else if (max < dp[i]) {
				max = dp[i];
				res = cnt[i];
			}
			
		}
		return res;
	}
	
	@Test
	public void test() {
		//Input: nums = [1,3,5,4,7]
		//Output: 2
		//Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
		Assertions.assertEquals(2, findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
		
		//Input: nums = [2,2,2,2,2]
		//Output: 5
		//Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
		Assertions.assertEquals(5, findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
	}
}
