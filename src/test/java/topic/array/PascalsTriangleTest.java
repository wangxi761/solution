package topic.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class PascalsTriangleTest {

	@Test
	public void testGenerate() {
		PascalsTriangle pascalsTriangle = new PascalsTriangle();
		pascalsTriangle.generate(5)
				.forEach(System.out::println);
	}

}
