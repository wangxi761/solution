package leetcode.problems.remove_nth_node_from_end_of_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import leetcode.struct.ListNode;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void removesNthNodeFromEnd() {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);
        int n = 2;
        ListNode expected = ListNode.create(1, 2, 3, 5);
        Assertions.assertEquals(expected, solution.removeNthFromEnd(head, n));
    }

    @Test
    public void removesFirstNodeFromEnd() {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);
        int n = 1;
        ListNode expected = ListNode.create(1, 2, 3, 4);
        Assertions.assertEquals(expected, solution.removeNthFromEnd(head, n));
    }

    @Test
    public void removesLastNodeFromEnd() {
        ListNode head = ListNode.create(1, 2, 3, 4, 5);
        int n = 5;
        ListNode expected = ListNode.create(2, 3, 4, 5);
        Assertions.assertEquals(expected, solution.removeNthFromEnd(head, n));
    }

    @Test
    public void handlesListWithSingleElement() {
        ListNode head = ListNode.create(1);
        int n = 1;
        ListNode expected = null;
        Assertions.assertEquals(expected, solution.removeNthFromEnd(head, n));
    }
}