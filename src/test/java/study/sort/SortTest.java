package study.sort;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class SortTest {


	public static Collection<Object[]> prepareData() {
		int[] array = new int[] {55, 94, 87, 1, 4, 32, 11, 77, 39, 42, 64, 53, 70, 12, 9};
		return Arrays.asList(new Object[][]{
			{Arrays.copyOf(array, array.length),new SelectionSort()},
			{Arrays.copyOf(array, array.length),new BubbleSort()},
			{Arrays.copyOf(array, array.length),new InsertionSort()},
			{Arrays.copyOf(array, array.length),new QuickSort()},
			{Arrays.copyOf(array, array.length),new MergeSort()},
			{Arrays.copyOf(array, array.length),new BucketSort()}
		});
	}
	@Test
	public void test() {
	}
	

}
