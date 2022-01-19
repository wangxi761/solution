package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import struct.ListNode;

public class LinkedListCycleII {


    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head, p2 = head, entry = head;
        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
            if (p1 == p2) {
                while (entry != p1) {
                    entry = entry.next;
                    p1 = p1.next;
                }
                return entry;
            }
        }
        return null;
    }

    @Test
    public void test() {
        ListNode d = new ListNode(-4);
        ListNode c = new ListNode(0, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(3, b);
        d.next = b;
        ListNode res = detectCycle(a);
        System.out.println();
    }
}
