package topic.backtracking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniquePathsIIITest {
	UniquePathsIII test = new UniquePathsIII();
	
	@Test
	public void uniquePathsIII() {
		int[][] gird = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
		assertEquals(2, test.uniquePathsIII(gird));
		
	}
	
}