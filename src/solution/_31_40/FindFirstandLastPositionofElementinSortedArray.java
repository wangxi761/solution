package solution._31_40;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FindFirstandLastPositionofElementinSortedArray {

	@Test
	public void test() throws Exception {
		int[] arr= {2,2};
		int[] searchRange = searchRange(arr, 3);
		System.out.println(Arrays.toString(searchRange));
	}

	public int[] searchRange(int[] nums, int target) {
		if(nums.length==0) {
			return new int[] {-1,-1}; 
		}
		int left=extremeInsertionIndex(nums, target);
		if(left>=nums.length||nums[left]!=target||left==nums.length) {
			return new int[] {-1,-1};
		}
		int right=extremeInsertionIndex(nums, target+1)-1;
		return new int[] {left,right};
	}

	private int extremeInsertionIndex(int[] nums, int target) {
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid =  (lo+hi)/2 ;
			if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
