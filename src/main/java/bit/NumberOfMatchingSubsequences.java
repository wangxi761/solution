
package bit;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfMatchingSubsequences {
	
	public int numMatchingSubseq(String s, String[] words) {
		Map<Character, Deque<String>> cache = new HashMap<>();
		for (char i = 'a'; i <= 'z'; i++) {
			cache.put(i, new LinkedList<>());
		}
		for (String word : words) {
			cache.get(word.charAt(0)).addLast(word);
		}
		
		int count=0;
		for (char c : s.toCharArray()) {
			Deque<String> deque = cache.get(c);
			int size = deque.size();
			for (int i = 0; i < size; i++) {
				String s1 = deque.removeFirst();
				if (s1.length() == 1) {
					count++;
				} else {
					cache.get(s1.charAt(1)).addLast(s1.substring(1));
				}
			}
		}
		return count;
	}
	

	
	
	@Test
	public void test() {
		assertEquals(3, numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
		assertEquals(2, numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
	}
}
