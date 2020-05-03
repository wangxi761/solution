package topic.array;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        return Arrays.stream(dp)
                     .max()
                     .getAsInt();
    }

    public int maxSubArray2(int[] nums) {
        int cur = nums[0], pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            pre = Math.max(cur, pre);
        }
        return pre;
    }

    @Test
    public void maxSubArrayTest() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = maxSubArray2(nums);
        assertEquals(6, maxSubArray);
    }
}
