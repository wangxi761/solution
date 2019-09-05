package topic.heap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		return Arrays.stream(words)
			.collect(Collectors.groupingBy(Function.identity(), () -> new LinkedHashMap<>(), Collectors.counting()))
			.entrySet()
			.stream()
			.sorted(Comparator.<Map.Entry<String, Long>, Long>comparing(stringLongEntry -> stringLongEntry.getValue()).reversed())
			.limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
	}
	
}
