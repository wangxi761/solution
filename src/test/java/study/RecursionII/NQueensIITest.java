package study.RecursionII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NQueensIITest {
	NQueensII test = new NQueensII();
	
	@Test
	public void totalNQueens() {
		assertEquals(2, test.totalNQueens(4));
	}
}