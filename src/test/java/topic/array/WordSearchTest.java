package topic.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordSearchTest {

	@Test
	public void exist() {
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		WordSearch wordSearch = new WordSearch();
		assertTrue(wordSearch.exist(board, "ABCCED"));
		assertTrue(wordSearch.exist(board, "SEE"));
		assertFalse(wordSearch.exist(board, "ABCB"));

	}
}


