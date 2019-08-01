package topic.trie;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestWordinDictionaryTest {
	LongestWordinDictionary test = new LongestWordinDictionary();
	
	@Test
	public void longestWord() {
		assertEquals("world", test.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
		assertEquals("apple", test.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
		assertEquals("latte", test.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"}));
	}
}