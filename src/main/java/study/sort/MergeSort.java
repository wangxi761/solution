package study.sort;

public class MergeSort implements Sort {

	@Override
	public void sort(int[] arr) {
		int[] result=new int[arr.length];
		sort(arr,result , 0, arr.length-1);
	}
	
	public void sort(int[] arr, int[] result, int start, int end) {
		if(start>=end)return;
		int mid = (end - start) / 2 + start;
		int l1=start,r1=mid,l2=mid+1,r2=end;
		sort(arr, result, l1, r1);
		sort(arr, result, l2, r2);
		int count=l1;
		while(l1<=r1&&l2<=r2) {
			result[count++]=arr[l1]>arr[l2]?arr[l2++]:arr[l1++];
		}
		while(l1<=r1) {
			result[count++]=arr[l1++];
		}
		while(l2<=r2) {
			result[count++]=arr[l2++];
		}
		System.arraycopy(result, start, arr, start, end-start+1);
	}
}
