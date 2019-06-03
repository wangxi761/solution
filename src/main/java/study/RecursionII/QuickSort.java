package study.RecursionII;

public class QuickSort {
	public void quickSort(int[] lst) {
		quickSort(lst, 0, lst.length - 1);
	}
	
	private void quickSort(int[] lst, int lo, int hi) {
		if (lo < hi) {
			int p = partition(lst, lo, hi);
			quickSort(lst, lo, p - 1);
			quickSort(lst, p + 1, hi);
		}
	}
	
	
	private int partition(int[] lst, int lo, int hi) {
		int tmp = lst[lo];
		while (lo < hi) {
			while (lo < hi && lst[hi] >= tmp) {
				hi--;
			}
			lst[lo] = lst[hi];
			while (lo < hi && lst[lo] <= tmp) {
				lo++;
			}
			lst[hi] = lst[lo];
		}
		lst[lo] = tmp;
		return lo;
	}
	
}
