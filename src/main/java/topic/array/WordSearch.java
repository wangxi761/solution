package topic.array;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board[0].length == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (search(board, word.toCharArray(), 0, i, j))
					return true;
			}
		}
		return false;
	}

	private boolean search(char[][] board, char[] words, int index, int i, int j) {
		if (index == words.length) return true;
		if (i == board.length || j == board[0].length || i < 0 || j < 0) return false;
		if (board[i][j] != words[index]) return false;
		board[i][j] ^= 256;
		boolean result = search(board, words, index + 1, i + 1, j) ||
				search(board, words, index + 1, i - 1, j) ||
				search(board, words, index + 1, i, j - 1) ||
				search(board, words, index + 1, i, j + 1);
		board[i][j] ^= 256;
		return result;
	}
}
