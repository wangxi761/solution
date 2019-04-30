package topic.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortedArrayTest {

	@Test
	public void test() {
		int[] nums1 = {4,5,6,0,0,0};
		int[] nums2 = {1,2,3};
		MergeSortedArray mergeSortedArray=new MergeSortedArray();
		mergeSortedArray.merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

}
