package topic.sort;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		int[][] candiate = new int[d.size()][26];
		int[] res = new int[d.size()];
		for (char c : s.toCharArray()) {
			for (int i = 0; i < d.size(); i++) {
				candiate[i][c - 'a']++;
			}
		}
		for (int i = 0; i < d.size(); i++) {
			for (char c : d.get(i).toCharArray()) {
				candiate[i][c - 'a']--;
			}
			for (int j = 0; j < candiate[i].length; j++) {
				if (candiate[i][j] < 0) {
					res[i] = -1;
					break;
				}
				if (candiate[i][j] > 0) {
					res[i] += 1;
				}
			}
		}
		return null;
	}
}
