package study.recursion;

import org.junit.jupiter.api.Test;

public class PascalsTriangleTest {
	PascalsTriangle test = new PascalsTriangle();
	
	@Test
	public void generate() {
		test.generate(5).forEach(i -> System.out.println(i));
	}
}