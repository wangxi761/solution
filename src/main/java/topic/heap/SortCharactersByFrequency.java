package topic.heap;

import java.util.Arrays;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		int[] ch = new int[128];
		for (int i = 0; i < ch.length; i++) {
			ch[i] += i;
		}
		for (char c : s.toCharArray()) {
			ch[c] += 1000;
		}
		Arrays.sort(ch);
		StringBuilder sb = new StringBuilder();
		for (int i = ch.length - 1; i >= 0; i--) {
			char c = (char) (ch[i] % 1000);
			int size = ch[i] / 1000;
			for (int j = 0; j < size; j++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
}
