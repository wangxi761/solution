package solution._2701_2800.Maximum_Number_of_Jumps_to_Reach_the_Last_Index;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution {
	public int maximumJumps(int[] nums, int target) {
		int[] dp = new int[nums.length];
		for (int i = dp.length - 1; i >= 0; i--) {
			dp[i] = i == dp.length - 1 ? 0 : -1;
			for (int j = i + 1; j < dp.length; j++) {
				if (-target <= nums[i] - nums[j] && nums[i] - nums[j] <= target && dp[j] != -1) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[0];
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(2, maximumJumps(new int[]{1, 2, 0, 3}, 1));
		
		//Input: nums = [1,3,6,4,1,2], target = 0
		//Output: -1
		Assertions.assertEquals(-1, maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 0));
		
		//Input: nums = [1,3,6,4,1,2], target = 2
		//Output: 3
		Assertions.assertEquals(3, maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 2));
		
		//Input: nums = [1,3,6,4,1,2], target = 3
		//Output: 5
		Assertions.assertEquals(5, maximumJumps(new int[]{1, 3, 6, 4, 1, 2}, 3));
		
	}
}