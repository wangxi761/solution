package topic.Backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniquePathsIIITest {
	topic.backtracking.UniquePathsIII test = new topic.backtracking.UniquePathsIII();
	
	@Test
	public void uniquePathsIII() {
		int[][] gird = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
		assertEquals(2, test.uniquePathsIII(gird));
		
	}
	
}