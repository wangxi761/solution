package topic.sort;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> res = new ArrayList<>();
		
	}
	
	public int findMax(int[] a, int begin, int end) {
		int max = Integer.MIN_VALUE;
		for (int i = begin; i < end; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}
	
}
