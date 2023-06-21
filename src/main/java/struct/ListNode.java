package struct;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode of(int... nums) {
        assert nums.length > 0;
        ListNode head = null;
        ListNode first = null;
        for (int num : nums) {
            if (head == null) {
                first = head = new ListNode(num);
            } else {
                head.next = new ListNode(num);
                head = head.next;
            }
        }
        return first;
    }
}
