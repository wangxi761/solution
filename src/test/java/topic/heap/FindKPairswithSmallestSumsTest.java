package topic.heap;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class FindKPairswithSmallestSumsTest {
	FindKPairswithSmallestSums test = new FindKPairswithSmallestSums();
	
	@Test
	public void kSmallestPairs() {
		test.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10).stream().forEach(System.out::println);
	}
	
}