package topic.string;

public class PalindromicSubstrings {
	
	public int countSubstrings(String s) {
		int length = s.length(), count = 0;
		for (int i = 0; i < 2 * length + 1; i++) {
			int left = i / 2, right = i / 2 + i % 2;
			while (left >= 0 && right < length
					&& s.charAt(left) == s.charAt(right)) {
				count++;
				left -= 1;
				right += 1;
			}
		}
		return count;
	}
	public int countSubstrings3(String s) {
		int len = s.length();
		int count = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				if (isPalindromic(s.substring(i, j)))
					count++;
			}
		}
		return count;

	}
	public boolean isPalindromic(String s) {
		int len = s.length();
		if (len == 1)
			return true;
		int i = len / 2 - 1, j = len / 2;
		while (i >= 0 && j < len) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i--;
			j++;
		}
		return true;
	}
}
