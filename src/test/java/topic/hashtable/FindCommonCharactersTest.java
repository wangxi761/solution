package topic.hashtable;

import org.junit.Test;

public class FindCommonCharactersTest {
	FindCommonCharacters test = new FindCommonCharacters();
	
	@Test
	public void commonChars() {
		System.out.println(test.commonChars(new String[]{"bella", "label", "roller"}));
	}
}