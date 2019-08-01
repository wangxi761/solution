package topic.trie;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestWordinDictionaryTest {
	LongestWordinDictionary test = new LongestWordinDictionary();
	
	@Test
	public void longestWord() {
		assertEquals("yodn", test.longestWord(new String[]{"yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod", "ewqz", "y"}));
		assertEquals("eyj", test.longestWord(new String[]{"ogz", "eyj", "e", "ey", "hmn", "v", "hm", "ogznkb", "ogzn", "hmnm", "eyjuo", "vuq", "ogznk", "og", "eyjuoi", "d"}));
		assertEquals("world", test.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
		assertEquals("apple", test.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
		assertEquals("latte", test.longestWord(new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"}));
	}
	
	@Test
	public void test() {
		System.out.println("ewqz".compareTo("yodn"));
		System.out.println("a".compareTo("b"));
		System.out.println("a".compareTo("c"));
		
	}
	
	
}