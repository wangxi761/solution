package study.sort;

public class QuickSort implements Sort {

	@Override
	public void sort(int[] arr) {
		sort(arr,0,arr.length-1);
	}

	public void sort(int[] arr, int head, int tail) {
		if (head >= tail || arr == null || arr.length <= 1)
			return;
		int i = head, j = tail, pivot = arr[(tail + head) / 2];
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if(i<j) {
				int t=arr[i];
				arr[i]=arr[j];
				arr[j]=t;
				i++;j--;
			}else if(i==j) {
				i++;
			}
		}
		sort(arr,head,j);
		sort(arr,i,tail);
	}
}
