package topic.backtracking;

import org.junit.Test;

import java.util.List;

public class GrayCodeTest {
	GrayCode test = new GrayCode();
	
	@Test
	public void grayCode() {
		List<Integer> list = test.grayCode(3);
		System.out.println(list);
	}
}