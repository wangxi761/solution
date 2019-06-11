package topic.Backtracking;

import org.junit.Test;

public class LetterCasePermutationTest {
	LetterCasePermutation test = new LetterCasePermutation();
	
	@Test
	public void letterCasePermutation() {
		test.letterCasePermutation("a1b2").forEach(System.out::println);
	}
}