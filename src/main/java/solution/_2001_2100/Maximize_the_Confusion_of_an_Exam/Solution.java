package solution._2001_2100.Maximize_the_Confusion_of_an_Exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Solution {
	public int maxConsecutiveAnswers(String answerKey, int k) {
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < answerKey.length(); i++) {
			map.put(answerKey.charAt(i), map.getOrDefault(answerKey.charAt(i), 0) + 1);
			int minor = Math.min(map.getOrDefault('T', 0), map.getOrDefault('F', 0));
			if (minor <= k) {
				max++;
			} else {
				map.put(answerKey.charAt(i - max), map.get(answerKey.charAt(i - max)) - 1);
			}
		}
		return max;
	}
	
	@Test
	public void test() {
		Assertions.assertEquals(8, maxConsecutiveAnswers("FFFTTFTTFT", 3));
		Assertions.assertEquals(5, maxConsecutiveAnswers("TTFTTFTT", 1));
		Assertions.assertEquals(4, maxConsecutiveAnswers("TTFF", 2));
		Assertions.assertEquals(3, maxConsecutiveAnswers("TFFT", 1));
	}
}

