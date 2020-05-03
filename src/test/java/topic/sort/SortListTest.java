package topic.sort;

import org.junit.jupiter.api.Test;
import struct.ListNode;

public class SortListTest {
	SortList test = new SortList();
	
	@Test
	public void sortList() {
		ListNode l1 = ListNode.create(1, 3, 2, 4, 6, 5, 9, 7, 0);
		System.out.println(test.sortList(l1).getList());
		
	}
}