package topic.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesfromSortedArrayIITest {

	@Test
	public void removeDuplicates() {
		int[] arr = {1, 1, 1, 2, 2, 3};
		RemoveDuplicatesfromSortedArrayII removeDuplicatesfromSortedArrayII = new RemoveDuplicatesfromSortedArrayII();
		removeDuplicatesfromSortedArrayII.removeDuplicates(arr);
		System.out.println(Arrays.toString(arr));
	}
}