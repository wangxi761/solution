package topic.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalRectangleTest {

	@Test
	public void maximalRectangle() {
		MaximalRectangle maximalRectangle = new MaximalRectangle();
		assertEquals(6,maximalRectangle.maximalRectangle(new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		}));
	}
}