package topic.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentWordsTest {
	TopKFrequentWords test = new TopKFrequentWords();
	
	@Test
	public void topKFrequent() {
		List<String> list = Arrays.stream(new String[]{"i", "love", "leetcode", "i", "love", "coding"})
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream()
			.sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(entry -> entry.getValue()).reversed().thenComparing(Map.Entry::getKey))
			.peek(i -> System.out.println(i.getKey()))
			.limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
		
		
	}
}
