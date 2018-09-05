package solution._21_30;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int count = 1;
		int num = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]==num)
				continue;
			num=nums[i];
			nums[count]=nums[i];
			count++;
		}
		System.out.println(Arrays.toString(nums));
		return count;
	}
	@Test
	public void test() throws Exception {
		int len = removeDuplicates(new int[] {1,1,2,3});
		assertEquals(3, len);
	}
}
