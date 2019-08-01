package topic.sort;

public class RelativeSortArray {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] candidate = new int[1001];
		int[] res = new int[arr1.length];
		int index = 0;
		for (int i = 0; i < arr1.length; i++) {
			candidate[arr1[i]]++;
		}
		for (int i = 0; i < arr2.length; i++) {
			while (candidate[arr2[i]]-- > 0) {
				res[index++] = arr2[i];
			}
		}
		for (int i = 0; i < candidate.length; i++) {
			while (candidate[i]-- > 0) {
				res[index++] = i;
			}
		}
		return res;
	}
	
}
