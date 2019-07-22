package solution._31_40;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<Character>[] row = new HashSet[9];
		Set<Character>[] column = new HashSet[9];
		Set<Character>[] square = new HashSet[9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				row[i].add(board[i][j]);
				column[j].add(board[i][j]);
			}
		}
	}
}
