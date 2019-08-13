package topic.sort;

import java.util.Arrays;

public class ReorganizeString {
	public String reorganizeString(String S) {
		char[] ch = S.toCharArray();
		int[] cnt = new int[26];
		for (char c : ch) {
			cnt[c - 'a']++;
		}
		for (int i = 0; i < cnt.length; i++) {
			cnt[i] = cnt[i] * 100 + i;
		}
		Arrays.sort(cnt);
		
		int index = 1;
		for (int i : cnt) {
			int size = i / 100;
			char c = (char) (i % 100 + 'a');
			if (size > (S.length() + 1) / 2) return "";
			if (size == 0) continue;
			for (int j = 0; j < size; j++) {
				if (index >= ch.length) index = 0;
				ch[index] = c;
				index += 2;
			}
		}
		return new String(ch);
	}
}
