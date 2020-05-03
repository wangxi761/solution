package topic.sort;

import org.junit.jupiter.api.Test;
import struct.ListNode;

public class InsertionSortListTest {
	InsertionSortList test = new InsertionSortList();
	
	@Test
	public void insertionSortList() {
		ListNode head = ListNode.create(3, 5, 1, 2, 4);
		System.out.println(test.insertionSortList(head).getList());
	}
}