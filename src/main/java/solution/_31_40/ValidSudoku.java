package solution._31_40;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<Character>[] row = new Set[9];
		Set<Character>[] column = new Set[9];
		Set<Character>[] square = new Set[9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') continue;
				if (row[i] == null) {
					row[i] = new HashSet<>();
				}
				if (!row[i].add(board[i][j])) {
					return false;
				}
				
				if (column[j] == null) {
					column[j] = new HashSet<>();
				}
				if (!column[j].add(board[i][j])) {
					return false;
				}
				
				int index = index(i, j);
				if (square[index] == null) {
					square[index] = new HashSet<>();
				}
				if (!square[index].add(board[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int index(int i, int j) {
		return i / 3 * 3 + j / 3;
	}
}
