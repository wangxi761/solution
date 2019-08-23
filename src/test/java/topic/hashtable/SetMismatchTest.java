package topic.hashtable;

import org.junit.Test;

public class SetMismatchTest {
	SetMismatch test = new SetMismatch();
	
	@Test
	public void findErrorNums() {
		System.out.println(test.findDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 6}));
	}
}