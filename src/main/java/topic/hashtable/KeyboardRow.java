package topic.hashtable;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {
	
	public String[] findWords(String[] words) {
		int[] key = {2, 1, 1, 2, 3, 2, 2, 2, 3, 2, 2, 2, 1, 1, 3, 3, 3, 3, 2, 3, 3, 1, 3, 1, 3, 1};
		List<String> list = new ArrayList<>();
		OUT:
		for (String word : words) {
			int num = key[Character.toLowerCase(word.charAt(0)) - 'a'];
			for (char c : word.toCharArray()) {
				if (key[Character.toLowerCase(c) - 'a'] != num) {
					continue OUT;
				}
			}
			list.add(word);
		}
		return list.toArray(new String[list.size()]);
	}
	
}
