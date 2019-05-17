package study.sort;

public class MergeSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if (arr == null || arr.length <= 1)
			return;
		int[] result=new int[arr.length];
		for (int i = 2; i < arr.length*2; i*=2) {
			for (int j = 0; j < (arr.length+i-1)/i; j++) {
				int start=i*j;
				int mid=start+i/2>=arr.length?arr.length-1:start+i/2;
				int end=i*(j+1)-1>=arr.length?arr.length-1:i*(j+1)-1;
				int l=start,m=mid,count=start;
				while(l<mid&&m<=end) {
					result[count++]=arr[l]>arr[m]?arr[m++]:arr[l++];
				}
				while(l<mid) {
					result[count++]=arr[l++];
				}
				while(m<=end) {
					result[count++]=arr[m++];
				}
				System.arraycopy(result, start, arr, start, end-start+1);
			}
		}
	}

	public void sort(int[] arr, int[] result, int start, int end) {
		if (start >= end)
			return;
		int mid = (end - start) / 2 + start;
		int l1 = start, r1 = mid, l2 = mid + 1, r2 = end;
		sort(arr, result, l1, r1);
		sort(arr, result, l2, r2);
		int count = l1;
		while (l1 <= r1 && l2 <= r2) {
			result[count++] = arr[l1] > arr[l2] ? arr[l2++] : arr[l1++];
		}
		while (l1 <= r1) {
			result[count++] = arr[l1++];
		}
		while (l2 <= r2) {
			result[count++] = arr[l2++];
		}
		System.arraycopy(result, start, arr, start, end - start + 1);
	}
}
