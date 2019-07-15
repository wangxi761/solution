package topic.backtracking;

import org.junit.Test;

public class PermutationsIITest {
	PermutationsII test = new PermutationsII();
	
	@Test
	public void permuteUnique() {
		test.permuteUnique(new int[]{1, 1, 2}).forEach(System.out::println);
	}
}