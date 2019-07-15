package topic.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		recursive(S.toCharArray(), 0, result);
		return result;
	}
	
	public void recursive(char[] chs, int count, List<String> result) {
		if (count == chs.length) {
			result.add(new String(chs));
			return;
		}
		if (!Character.isLetter(chs[count])) {
			recursive(chs, count + 1, result);
			return;
		}
		chs[count] = Character.toUpperCase(chs[count]);
		recursive(chs, count + 1, result);
		chs[count] = Character.toLowerCase(chs[count]);
		recursive(chs, count + 1, result);
	}
	
}
