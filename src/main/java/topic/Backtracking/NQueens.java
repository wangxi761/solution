package topic.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<Integer> column = new ArrayList<>();
		List<Integer> diagonal1 = new ArrayList<>();
		List<Integer> diagonal2 = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();
		recursive(result, new ArrayList<>(), column, diagonal1, diagonal2, 0, n);
		return result;
	}
	
	public void recursive(List<List<String>> results, List<String> result, List<Integer> column, List<Integer> diagonal1, List<Integer> diagonal2, int row, int n) {
		if (row == n) {
			results.add(new ArrayList<>(result));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (set(column, diagonal1, diagonal2, i, row)) {
				result.add(buildStr(i, n));
				column.add(i);
				diagonal1.add(i - row);
				diagonal2.add(i + row);
				
				recursive(results, result, column, diagonal1, diagonal2, row + 1, n);
				
				column.remove(column.size() - 1);
				diagonal1.remove(diagonal1.size() - 1);
				diagonal2.remove(diagonal2.size() - 1);
				result.remove(result.size() - 1);
			}
		}
	}
	
	public String buildStr(int i, int n) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++) {
			if (j == i) {
				sb.append("Q");
			} else {
				sb.append(".");
			}
		}
		return sb.toString();
	}
	
	public boolean set(List<Integer> column, List<Integer> diagonal1, List<Integer> diagonal2, int x, int y) {
		return !column.contains(x) && !diagonal1.contains(x - y) && !diagonal2.contains(x + y);
	}
}
