package leetcode.problems.linked_list_cycle_ii;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import leetcode.struct.ListNode;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void detectsCycleInListWithCycle() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle back to node2
        Assertions.assertEquals(node2, solution.detectCycle(head));
    }

    @Test
    public void returnsNullForListWithoutCycle() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        Assertions.assertNull(solution.detectCycle(head));
    }

    @Test
    public void handlesEmptyList() {
        ListNode head = null;
        Assertions.assertNull(solution.detectCycle(head));
    }

    @Test
    public void handlesListWithSingleElement() {
        ListNode head = new ListNode(1);
        Assertions.assertNull(solution.detectCycle(head));
    }

    @Test
    public void handlesListWithTwoElementsAndNoCycle() {
        ListNode head = new ListNode(1, new ListNode(2));
        Assertions.assertNull(solution.detectCycle(head));
    }

    @Test
    public void detectsCycleInListWithTwoElementsAndCycle() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        node2.next = head; // cycle back to head
        Assertions.assertEquals(head, solution.detectCycle(head));
    }
}