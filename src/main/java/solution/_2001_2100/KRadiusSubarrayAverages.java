package solution._2001_2100;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KRadiusSubarrayAverages {
	public int[] getAveragesI(int[] nums, int k) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i < k || nums.length - i - 1 < k) {
				res[i] = -1;
				continue;
			}
			long sum = 0;
			for (int j = i - k; j <= i + k; j++) {
				sum += nums[j];
			}
			res[i] = (int) (sum / (k * 2 + 1));
		}
		return res;
	}
	
	public int[] getAveragesII(int[] nums, int k) {
		int[] res = new int[nums.length];
		long[][] dp = new long[nums.length][nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i][i] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				dp[i][j] = dp[i][j - 1] + nums[j];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < k || nums.length - i - 1 < k) {
				res[i] = -1;
				continue;
			}
			res[i] = (int) (dp[i - k][i + k] / (k * 2 + 1));
		}
		return res;
	}
	
	public int[] getAverages(int[] nums, int k) {
		long[] res = new long[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (i < k || nums.length - i - 1 < k) {
				res[i] = -1;
				continue;
			}
			if (i > 0 && i + k < nums.length && res[i - 1] != -1) {
				res[i] = res[i - 1] - nums[i - 1 - k] + nums[i + k];
				continue;
			}
			long sum = 0;
			for (int j = i - k; j <= i + k; j++) {
				sum += nums[j];
			}
			res[i] = sum;
		}
		int[] arr = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			if (res[i] == -1) {
				arr[i] = -1;
			} else {
				arr[i] = ((int) (res[i] / (k * 2 + 1)));
			}
		}
		return arr;
	}
	
	@Test
	public void test() {
		int[] averages = getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3);
		Assertions.assertArrayEquals(new int[]{-1, -1, -1, 5, 4, 4, -1, -1, -1}, averages);
	}
}

