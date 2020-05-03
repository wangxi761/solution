package topic.array;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;
        int i = 0, max = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                int low = stack.pop();
                max += stack.isEmpty() ? 0 : (Math.min(height[stack.peek()], height[i]) - height[low]) * (i - stack.peek() - 1);

            }
        }
        return max;
    }

    public int trap2(int[] height) {
        int[][] dp = new int[height.length][2];
        int i = 1;
        while (i < height.length) {
            dp[i][0] = Math.max(height[i - 1], dp[i - 1][0]);
            i++;
        }
        i = height.length - 2;
        while (i >= 0) {
            dp[i][1] = Math.max(dp[i + 1][1], height[i + 1]);
            i--;
        }
        i = 0;
        Arrays.stream(dp).forEach(d -> System.out.println(Arrays.toString(d)));
        for (int j = 0; j < height.length; j++) {
            int min = Math.min(dp[j][0], dp[j][1]);
            i += height[j] >= min ? 0 : min - height[j];
        }
        return i;
    }

    @Test
    public void trapTest() {
        int[] arrs = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap2(arrs);
        System.out.println(trap);
    }
}
