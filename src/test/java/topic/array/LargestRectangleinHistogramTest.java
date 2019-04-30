package topic.array;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestRectangleinHistogramTest {

	@Test
	public void test() {
		LargestRectangleinHistogram histogram=new LargestRectangleinHistogram();
		int[] arr= {2,1,5,6,2,3};
		assertEquals(10, histogram.largestRectangleArea(arr));
	}

}
