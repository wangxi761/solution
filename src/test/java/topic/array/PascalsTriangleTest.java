package topic.array;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PascalsTriangleTest {

	@Test
	public void testGenerate() {
		PascalsTriangle pascalsTriangle = new PascalsTriangle();
		pascalsTriangle.generate(5)
				.forEach(System.out::println);
	}

}
