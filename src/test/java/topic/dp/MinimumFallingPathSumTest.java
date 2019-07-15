package topic.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumFallingPathSumTest {
	MinimumFallingPathSum test = new MinimumFallingPathSum();
	
	@Test
	public void minFallingPathSum() {
		assertEquals(12, test.minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
	}
}