package other.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuickSort {
	
	@Test
	public void test() {
		int[] arr = {64, 34, 25, 12, 22, 11, 90};
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public void quicksortII(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int p = arr[l], lt = l, gt = r, i = l + 1;
		
		while (i <= gt) {
			if (arr[i] < p) {
				swap(arr, lt++, i++);
			} else if (arr[i] > p) {
				swap(arr, i, gt--);
			} else {
				i++;
			}
		}
		quicksort(arr, l, lt - 1);
		quicksort(arr, gt + 1, r);
	}
	
	
	public void quicksort(int[] arr, int l, int r) {
		if (l < r) {
			int p = partition(arr, l, r);
			quicksort(arr, l, p - 1);
			quicksort(arr, p + 1, r);
		}
	}
	
	public int partition(int[] arr, int l, int r) {
		int p = arr[(l + r) / 2], i = l - 1, j = r + 1;
		while (true) {
			do {
				i++;
			} while (arr[i] < p);
			do {
				j--;
			} while (arr[j] > p);
			if (i >= j) {
				return j;
			}
			swap(arr, i, j);
		}
	}
	
	
	public int partitionI(int[] arr, int l, int r) {
		int pv = arr[l + (r - l) / 2];
		int i = l - 1;
		int j = r + 1;
		while (true) {
			do {
				i++;
			} while (arr[i] < pv);
			do {
				j--;
			} while (arr[j] > pv);
			if (i >= j) {
				return j;
			}
			swap(arr, i, j);
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
}
