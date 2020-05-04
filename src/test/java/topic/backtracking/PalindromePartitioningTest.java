package topic.backtracking;

import org.junit.jupiter.api.Test;
import topic.backtracking.PalindromePartitioning;

public class PalindromePartitioningTest {
	PalindromePartitioning test = new PalindromePartitioning();
	
	@Test
	public void partition() {
		test.partition("aab").forEach(System.out::println);
	}
}