package study.RecursionII;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
	public int totalNQueens(int n) {
		List<Integer> column = new ArrayList<>();
		List<Integer> diagonal1 = new ArrayList<>();
		List<Integer> diagonal2 = new ArrayList<>();
		return recursive(column, diagonal1, diagonal2, n);
	}
	
	public int recursive(List<Integer> column, List<Integer> diagonal1, List<Integer> diagonal2, int n) {
		int row = column.size();
		if (row == n) {
			return 1;
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (set(column, diagonal1, diagonal2, i, row)) {
				column.add(i);
				diagonal1.add(i - row);
				diagonal2.add(i + row);
				
				sum += recursive(column, diagonal1, diagonal2, n);
				
				column.remove(column.size() - 1);
				diagonal1.remove(diagonal1.size() - 1);
				diagonal2.remove(diagonal2.size() - 1);
			}
		}
		return sum;
	}
	
	public boolean set(List<Integer> column, List<Integer> diagonal1, List<Integer> diagonal2, int x, int y) {
		return !column.contains(x) && !diagonal1.contains(x - y) && !diagonal2.contains(x + y);
	}
	
}
