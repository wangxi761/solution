package topic.sort;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> res = new ArrayList<>();
		for (int i = A.length - 1; i >= 0; i--) {
			int id = findMax(A, 0, i + 1);
			if (id == i) {
				continue;
			}
			reverse(A, 0, id + 1, res);
			reverse(A, 0, i + 1, res);
		}
		return res;
	}
	
	public int findMax(int[] a, int begin, int end) {
		if (begin == end) return begin;
		int max = Integer.MIN_VALUE, index = -1;
		for (int i = begin; i < end; i++) {
			if (a[i] > max) {
				max = a[i];
				index = i;
			}
		}
		return index;
	}
	
	public void reverse(int[] arr, int begin, int end, List<Integer> res) {
		end--;
		if (begin >= end) {
			return;
		}
		res.add(end + 1);
		while (begin < end) {
			int tmp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = tmp;
			begin++;
			end--;
		}
	}
}
