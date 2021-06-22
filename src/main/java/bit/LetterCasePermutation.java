
package bit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class LetterCasePermutation {
	
	public List<String> letterCasePermutation(String s) {
		List<String> res = new ArrayList<>();
		backtrack(s.toCharArray(), 0, res);
		return new ArrayList<>(res);
	}
	
	public void backtrack(char[] chs, int index, List<String> res) {
		if (index == chs.length) {
			res.add(new String(chs));
			return;
		}
		if (!Character.isLetter(chs[index])) {
			backtrack(chs, index + 1, res);
			return;
		}
		backtrack(chs, index + 1, res);
		if (Character.isUpperCase(chs[index])) {
			chs[index] = Character.toLowerCase(chs[index]);
		} else {
			chs[index] = Character.toUpperCase(chs[index]);
		}
		backtrack(chs, index + 1, res);
		
	}
	
	@Test
	public void test() {
		assertLinesMatch(Arrays.asList("a1b2", "a1B2", "A1b2", "A1B2"), letterCasePermutation("a1b2"));
		assertLinesMatch(Arrays.asList("3z4", "3Z4"), letterCasePermutation("3z4"));
		assertLinesMatch(Arrays.asList("12345"), letterCasePermutation("12345"));
		assertLinesMatch(Arrays.asList("0"), letterCasePermutation("0"));
	}
}
