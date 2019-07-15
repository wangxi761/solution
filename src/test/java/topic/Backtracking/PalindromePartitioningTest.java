package topic.backtracking;

import org.junit.Test;

public class PalindromePartitioningTest {
	PalindromePartitioning test = new PalindromePartitioning();
	
	@Test
	public void partition() {
		test.partition("aab").forEach(System.out::println);
	}
}