package topic.sort;

import org.junit.jupiter.api.Test;

public class PancakeSortingTest {
	PancakeSorting test = new PancakeSorting();
	
	@Test
	public void pancakeSort() {
		System.out.println(test.pancakeSort(new int[]{3, 2, 4, 1}));
		System.out.println(test.pancakeSort(new int[]{1, 2, 3}));
	}
}
