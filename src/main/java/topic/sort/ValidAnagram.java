package topic.sort;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 97]++;
		}
		for (char c : t.toCharArray()) {
			count[c - 97]--;
		}
		for (int i : count) {
			if (i != 0) {
				return false;
			}
		}
		return true;
	}
}
