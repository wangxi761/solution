package leetcode.problems.intersection_of_two_linked_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import leetcode.struct.ListNode;

public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void findsIntersectionInTwoIntersectingLists() {
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, common));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, common)));
        Assertions.assertEquals(common, solution.getIntersectionNode(headA, headB));
    }

    @Test
    public void returnsNullForNonIntersectingLists() {
        ListNode headA = new ListNode(1, new ListNode(9, new ListNode(1, new ListNode(2, new ListNode(4)))));
        ListNode headB = new ListNode(3, new ListNode(2, new ListNode(4)));
        Assertions.assertNull(solution.getIntersectionNode(headA, headB));
    }

    @Test
    public void handlesEmptyListA() {
        ListNode headA = null;
        ListNode headB = new ListNode(1, new ListNode(2, new ListNode(3)));
        Assertions.assertNull(solution.getIntersectionNode(headA, headB));
    }

    @Test
    public void handlesEmptyListB() {
        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode headB = null;
        Assertions.assertNull(solution.getIntersectionNode(headA, headB));
    }

    @Test
    public void handlesBothListsBeingEmpty() {
        ListNode headA = null;
        ListNode headB = null;
        Assertions.assertNull(solution.getIntersectionNode(headA, headB));
    }
}