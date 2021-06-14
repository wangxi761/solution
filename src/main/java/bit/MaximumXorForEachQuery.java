package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximumXorForEachQuery {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxK = (int) Math.pow(2, maximumBit) - 1;
        int[] res = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum ^= nums[i];
            res[nums.length - i - 1] = maxK ^ sum;
        }
        return res;
    }

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[]{0,3,2,3},getMaximumXor(new int[]{0,1,1,3},2));
        Assertions.assertArrayEquals(new int[]{5,2,6,5},getMaximumXor(new int[]{2,3,4,7},3));
        Assertions.assertArrayEquals(new int[]{4,3,6,4,6,7},getMaximumXor(new int[]{0,1,2,2,5,7},3));
    }
}
