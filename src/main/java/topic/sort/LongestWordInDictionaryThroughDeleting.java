package topic.sort;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		String res = "";
		for (String str : d) {
			int i = 0;
			for (char c : s.toCharArray()) {
				if (i < str.length() && c == str.charAt(i)) i++;
			}
			
			if (i == str.length() && str.length() >= res.length()) {
				if (str.length() > res.length() || res.compareTo(str) >= 0) {
					res = str;
				}
			}
		}
		return res;
	}
}
