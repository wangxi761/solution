package topic.heap;

import org.junit.jupiter.api.Test;

public class SuperUglyNumberTest {
	SuperUglyNumber test = new SuperUglyNumber();
	
	@Test
	public void nthSuperUglyNumber() {
		System.out.println(test.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
	}
}