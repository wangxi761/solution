package leetcode.problems.swap_nodes_in_pairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import leetcode.struct.ListNode;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void swapsPairsInListWithEvenNumberOfNodes() {
        ListNode head = ListNode.create(1, 2, 3, 4);
        ListNode expected = ListNode.create(2, 1, 4, 3);
        Assertions.assertEquals(expected, solution.swapPairs(head));
    }

    @Test
    public void swapsPairsInListWithOddNumberOfNodes() {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);
        ListNode expected = ListNode.create(2, 1, 4, 3, 5);
        Assertions.assertEquals(expected, solution.swapPairs(head));
    }

    @Test
    public void handlesEmptyList() {
        ListNode head = null;
        ListNode expected = null;
        Assertions.assertEquals(expected, solution.swapPairs(head));
    }

    @Test
    public void handlesListWithSingleElement() {
        ListNode head = ListNode.create(1);
        ListNode expected = ListNode.create(1);
        Assertions.assertEquals(expected, solution.swapPairs(head));
    }

    @Test
    public void handlesListWithTwoElements() {
        ListNode head = ListNode.create(1, 2);
        ListNode expected = ListNode.create(2, 1);
        Assertions.assertEquals(expected, solution.swapPairs(head));
    }
}