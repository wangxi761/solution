package solution._21_30;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
