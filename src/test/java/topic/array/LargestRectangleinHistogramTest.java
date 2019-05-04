package topic.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestRectangleinHistogramTest {

	@Test
	public void test() {
		LargestRectangleinHistogram histogram=new LargestRectangleinHistogram();
//		assertEquals(10, histogram.largestRectangleArea(new int[]{2,1,5,6,2,3}));
//		assertEquals(1, histogram.largestRectangleArea(new int[]{1}));
//		assertEquals(2, histogram.largestRectangleArea(new int[]{2,0,2}));
		assertEquals(3, histogram.largestRectangleArea(new int[]{2, 1, 2}));

	}

}
