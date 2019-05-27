package topic.string;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
	public int countBinarySubstrings(String s) {
		int cur = 1, pre = 0, result = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				result += Math.min(cur, pre);
				pre = cur;
				cur = 1;
			} else {
				cur++;
			}
		}
		return result + Math.min(cur, pre);
	}
	
	
	public int countBinarySubstrings2(String s) {
		List<Integer> list = new ArrayList<>();
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				list.add(count);
				count = 1;
			} else {
				count++;
			}
		}
		if (count > 0) list.add(count);
		count = 0;
		for (int i = 1; i < list.size(); i++) {
			count += Math.min(list.get(i), list.get(i - 1));
		}
		return count;
	}
	
	public int countBinarySubstrings1(String s) {
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				continue;
			}
			count++;
			for (int j = i - 1, k = i + 2; j >= 0 && k < s.length(); j--, k++) {
				if (s.charAt(j) == s.charAt(i) && s.charAt(k) == s.charAt(i + 1))
					count++;
				else
					break;
			}
		}
		return count;
	}
	
}
