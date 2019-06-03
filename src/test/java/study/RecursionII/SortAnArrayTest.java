package study.RecursionII;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortAnArrayTest {
	SortAnArray test = new SortAnArray();
	
	@Test
	public void mergeInPlace() {
		int[] arr = {5, 1, 1, 2, 0, 0};
		test.sortArray(arr);
		System.out.println(Arrays.toString(arr));
	}
}