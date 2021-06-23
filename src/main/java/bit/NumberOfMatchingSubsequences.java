
package bit;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfMatchingSubsequences {
	
	public int numMatchingSubseq(String s, String[] words) {
		Set<String> cache = new HashSet<>();
		int sum = 0;
		for (String word : words) {
			if (isSub(s, word, cache)) sum++;
		}
		return sum;
	}
	
	public boolean isSub(String s, String word, Set<String> cache) {
		if (cache.contains(word)) {
			return true;
		}
		int cur = 0;
		for (int i = 0; i < word.length(); i++) {
			String str = word.substring(i, i + 1);
			int index = s.indexOf(str, cur);
			if (index < 0) {
				return false;
			}
			cache.add(str);
			cur = index + 1;
		}
		return true;
	}
	
	
	@Test
	public void test() {
		assertEquals(3, numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
		assertEquals(2, numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
	}
}
