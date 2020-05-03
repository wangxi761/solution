package study.RecursionII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchA2DMatrixIITest {
	SearchA2DMatrixII test = new SearchA2DMatrixII();
	
	@Test
	public void searchMatrix() {
		int[] arr = {1, 2, 3, 5, 6, 7, 8, 9};
		test.binarySearch(arr, 13);
	}
}