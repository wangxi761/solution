package topic.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> results = new ArrayList<>();
		recursive(results, new ArrayList<>(), s, 0);
		return results;
	}
	
	public void recursive(List<List<String>> results, List<String> result, String s, int start) {
		if (start == s.length()) {
			results.add(new ArrayList<>(result));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (!isPalindrome(s, start, i)) continue;
			result.add(s.substring(start, i + 1));
			recursive(results, result, s, i + 1);
			result.remove(result.size() - 1);
		}
	}
	
	
	public boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) return false;
		}
		return true;
	}
	
	public boolean isPalindrome1(String s, int start, int end) {
		int mid = start + (end - start) / 2;
		int left = mid % 2 == 0 ? mid : mid - 1, right = mid + 1;
		while (left >= start && right <= end) {
			if (s.charAt(left--) != s.charAt(right++)) return false;
		}
		return true;
	}
}
