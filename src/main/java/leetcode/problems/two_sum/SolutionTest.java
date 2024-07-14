package leetcode.problems.two_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void findsTwoNumbersAddingUpToTarget() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    public void handlesTargetBeingSumOfFirstAndLastElement() {
        int[] nums = {3, 2, 4};
        int target = 7;
        int[] expected = {2, 0};
        Assertions.assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    public void handlesTargetBeingSumOfMiddleElements() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    public void handlesArrayWithTwoElements() {
        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    public void returnsNullWhenNoSolutionExists() {
        int[] nums = {3, 2, 4};
        int target = 10;
        Assertions.assertNull(solution.twoSum(nums, target));
    }
}