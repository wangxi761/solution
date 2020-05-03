package topic.hashtable;

import org.junit.jupiter.api.Test;

public class ShortestCompletingWordTest {
	ShortestCompletingWord test = new ShortestCompletingWord();
	
	@Test
	public void shortestCompletingWord() {
		System.out.println(test.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
	}
}