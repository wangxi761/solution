package topic.hashtable;

import org.junit.Test;

public class ContainsDuplicateTest {
	ContainsDuplicate test = new ContainsDuplicate();
	
	@Test
	public void containsDuplicate() {
		System.out.println(test.containsDuplicate(new int[]{1, 0}));
	}
}