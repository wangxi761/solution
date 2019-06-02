package study.RecursionII;

public class QuickSort {
	public void quickSort(int[] lst) {
	
	}
	
	public void quickSort(int[] lst, int lo, int hi) {
		if (lo >= hi) return;
		int pivot = (hi - lo) / 2 + lo;
		int i = lo, j = hi;
		int tmp;
		while (i < j) {
			if (lst[i] > lst[pivot]) {
				tmp = lst[i];
			}
		}
	}
	
}
