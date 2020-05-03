package topic.sort;

import org.junit.jupiter.api.Test;

public class CountofSmallerNumbersAfterSelfTest {
	CountofSmallerNumbersAfterSelf test = new CountofSmallerNumbersAfterSelf();
	
	@Test
	public void countSmaller() {
		System.out.println(test.countSmaller(new int[]{5, 2, 6, 1}));
	}
	
	@Test
	public void test() {
		System.out.println(test.lower_bound(new int[]{1, 3, 3, 3, 5}, 0, 5, 3));
	}
}