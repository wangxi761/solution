package topic.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaximalRectangleTest {

	@Test
	public void maximalRectangle() {
		MaximalRectangle maximalRectangle = new MaximalRectangle();
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		maximalRectangle.maximalRectangle(matrix);
	}
}