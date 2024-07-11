package leetcode.problems.happy_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void identifiesHappyNumber() {
        Assertions.assertTrue(solution.isHappy(19));
    }

    @Test
    public void identifiesNonHappyNumber() {
        Assertions.assertFalse(solution.isHappy(2));
    }

    @Test
    public void handlesNumberOne() {
        Assertions.assertTrue(solution.isHappy(1));
    }

    @Test
    public void handlesLargeNumber() {
        Assertions.assertFalse(solution.isHappy(99999999));
    }
}