package daily;

import struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {


    private ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode p = this.head;
        int i=1,num=0;
        while (p != null) {
            if (Math.random() * i++ < 1) {
                num = p.val;
            }
            p = p.next;
        }
        return num;
    }

}
