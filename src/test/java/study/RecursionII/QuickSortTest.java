package study.RecursionII;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
	
	
	QuickSort test = new QuickSort();
	
	
	@Test
	public void quickSort() {
		Random random = new Random();
		int[] arr = random.ints(10, 0, 100).toArray();
		System.out.println(Arrays.toString(arr));
		test.quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}