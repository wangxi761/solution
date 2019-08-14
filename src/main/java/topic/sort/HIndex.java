package topic.sort;

import java.util.Arrays;

public class HIndex {
	
	
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length - i) {
				return citations.length - i;
			}
		}
		return 0;
	}
	
}
