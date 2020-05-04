package topic.backtracking;

import org.junit.jupiter.api.Test;
import topic.backtracking.NQueens;

import java.util.List;

public class NQueensTest {
	NQueens test = new NQueens();
	
	@Test
	public void solveNQueens() {
		List<List<String>> lists = test.solveNQueens(4);
		lists.forEach(System.out::println);
	}
}