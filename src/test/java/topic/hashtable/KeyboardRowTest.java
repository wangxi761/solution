package topic.hashtable;

import org.junit.jupiter.api.Test;
import util.ArrayUtil;

public class KeyboardRowTest {
	KeyboardRow test = new KeyboardRow();
	
	@Test
	public void findWords() {
		String[] str = {"Hello", "Alaska", "Dad", "Peace"};
		ArrayUtil.prettyPrint(test.findWords(str));
	}
}