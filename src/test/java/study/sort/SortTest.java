package study.sort;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class SortTest {
	@Parameter
	public int[] arr;
	@Parameter(1)
	public Sort test;


	@Parameters(name = "{index}: {1}")
	public static Collection<Object[]> prepareData() {
		int[] array = new int[] {55, 94, 87, 1, 4, 32, 11, 77, 39, 42, 64, 53, 70, 12, 9};
		return Arrays.asList(new Object[][]{
			{Arrays.copyOf(array, array.length),new BubbleSort()},
			{Arrays.copyOf(array, array.length),new InsertionSort()}
		});
	}

	@Test
	public void test() {
		test.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	

}
