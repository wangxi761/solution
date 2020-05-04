package topic.Backtracking;

import org.junit.jupiter.api.Test;

public class PermutationsIITest {
	topic.backtracking.PermutationsII test = new topic.backtracking.PermutationsII();
	
	@Test
	public void permuteUnique() {
		test.permuteUnique(new int[]{1, 1, 2}).forEach(System.out::println);
	}
}