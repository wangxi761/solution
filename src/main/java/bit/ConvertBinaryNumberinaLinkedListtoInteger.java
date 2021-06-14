package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConvertBinaryNumberinaLinkedListtoInteger {
    public int getDecimalValue(ListNode head) {
        int sum=0;
        while (head!= null) {
            sum=sum*2+head.val;
            head=head.next;
        }
        return sum;
    }

    @Test
    public void test() {
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
