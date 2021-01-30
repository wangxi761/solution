package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0,j=0;
		List<Integer> list=new ArrayList<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}
		int[] res = new int[list.size()];
		for (int k = 0; k < res.length; k++) {
			res[k] = list.get(k);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,6};
		int[] arr2 = {1,6};
		
		Intersect intersect=new Intersect();
		int[] res = intersect.intersect(arr1, arr2);
		System.out.println(Arrays.toString(res));
	}
}
