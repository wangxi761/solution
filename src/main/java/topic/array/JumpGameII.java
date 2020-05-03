package topic.array;


import org.junit.jupiter.api.Test;

public class JumpGameII {
	/**
	 * Time Limit Exceeded
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (nums[j] >= i - j) {
					min = min > dp[j] + 1 ? dp[j] + 1 : min;
				}
			}
			dp[i] = min;
		}
		return dp[nums.length - 1];
	}

	public int jump2(int[] nums) {
		int cur = 0, pre = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if(i>pre) {
				pre=cur;
				count++;
			}
			cur=Math.max(i+nums[i], cur);
		}
		return count;
	}

	@Test
	public void test() throws Exception {
		int[] arr = { 2, 3, 1, 1, 4 };
		System.out.println(jump2(arr));
	}
}
