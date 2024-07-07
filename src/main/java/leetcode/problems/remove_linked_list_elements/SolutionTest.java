package leetcode.problems.remove_linked_list_elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import leetcode.struct.ListNode;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void removesAllOccurrencesOfValue() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        int val = 2;
        ListNode expected = new ListNode(1, new ListNode(1));
        Assertions.assertEquals(expected, solution.removeElements(head, val));
    }

    @Test
    public void handlesEmptyList() {
        ListNode head = null;
        int val = 1;
        ListNode expected = null;
        Assertions.assertEquals(expected, solution.removeElements(head, val));
    }

    @Test
    public void handlesListWithoutOccurrences() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        int val = 4;
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3)));
        Assertions.assertEquals(expected, solution.removeElements(head, val));
    }

    @Test
    public void handlesListWithAllOccurrences() {
        ListNode head = new ListNode(2, new ListNode(2, new ListNode(2)));
        int val = 2;
        ListNode expected = null;
        Assertions.assertEquals(expected, solution.removeElements(head, val));
    }
}