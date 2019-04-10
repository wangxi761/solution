package topic.array;

import org.junit.Test;

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

    @Test
    public void trap1() {
        int[] arrs = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = trap(arrs);
        System.out.println(trap);
    }
}
