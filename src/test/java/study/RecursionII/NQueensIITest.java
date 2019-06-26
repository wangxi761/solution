package study.RecursionII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NQueensIITest {
	NQueensII test = new NQueensII();
	
	@Test
	public void totalNQueens() {
		assertEquals(2, test.totalNQueens(4));
	}
}