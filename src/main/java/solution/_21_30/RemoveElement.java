package solution._21_30;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int i=0,j=0;
		int count=0;
		while(i<nums.length) {
			j=i+1;
			if(nums[i]==val) {
				while(j<nums.length&&nums[j]==nums[i]) {
					j++;
				}
				if(i<nums.length&&j<nums.length) {
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
					count++;
				}
			}else {
				count++;
			}
			i++;
		}
		System.out.println(Arrays.toString(nums));
		return count;
	}
	@Test
	public void test() throws Exception {
		int element = removeElement(new int[] {0,1,2,2,3,0,4,2}, 2);
		assertEquals(5, element);
	}
}
