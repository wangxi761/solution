package topic.backtracking;

import org.junit.Test;

import java.util.List;

public class NQueensTest {
	NQueens test = new NQueens();
	
	@Test
	public void solveNQueens() {
		List<List<String>> lists = test.solveNQueens(4);
		lists.forEach(System.out::println);
	}
}