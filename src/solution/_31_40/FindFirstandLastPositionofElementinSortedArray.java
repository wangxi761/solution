package solution._31_40;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FindFirstandLastPositionofElementinSortedArray {

	@Test
	public void test() throws Exception {
		int[] searchRange = searchRange(new int[] {2,2}, 3);
		String str = Arrays.toString(searchRange);
		System.out.println(str);
	}

	public int[] searchRange(int[] nums, int target) {
		if(nums.length==0) {
			return new int[] {-1,-1}; 
		}
		int left=extremeInsertionIndex(nums, target);
		if(nums[left]!=target||left==nums.length) {
			return new int[] {-1,-1};
		}
		return new int[] {left,extremeInsertionIndex(nums, target+1)-1};
	}

	private int extremeInsertionIndex(int[] nums, int target) {
		int lo = 0, hi = nums.length;
		while (lo < hi) {
			int mid =  lo + (hi-lo)/2 ;
			if (nums[mid] < target) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
		return lo;
	}
}
