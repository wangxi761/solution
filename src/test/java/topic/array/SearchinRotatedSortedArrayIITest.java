package topic.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchinRotatedSortedArrayIITest {

	@Test
	public void search() {
		int[] arrs = {2, 5, 6, 0, 0, 1, 2};
		int[] arrs1 = {3, 1};
		SearchinRotatedSortedArrayII searchinRotatedSortedArrayII = new SearchinRotatedSortedArrayII();
		assertTrue(searchinRotatedSortedArrayII.search(arrs, 0));
		assertTrue(searchinRotatedSortedArrayII.search(arrs1, 1));
	}
}