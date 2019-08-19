package topic.hashtable;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
	public List<String> commonChars(String[] A) {
		List<String> res = new ArrayList<>();
		if (A == null || A.length == 0) {
			return res;
		}
		int[] letters = new int[26];
		countChars(letters, A[0]);
		for (int i = 1; i < A.length; i++) {
			int[] temp = new int[26];
			countChars(temp, A[i]);
			for (int j = 0; j < temp.length; j++) {
				letters[j] = Math.min(letters[j], temp[j]);
			}
		}
		for (int i = 0; i < letters.length; i++) {
			for (int j = 0; j < letters[i]; j++) {
				res.add((char) ('a' + i) + "");
			}
		}
		return res;
	}
	
	public void countChars(int[] nums, String str) {
		for (char c : str.toCharArray()) {
			nums[c - 'a']++;
		}
	}
	
}
