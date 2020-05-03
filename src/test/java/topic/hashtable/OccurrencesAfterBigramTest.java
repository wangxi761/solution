package topic.hashtable;

import org.junit.jupiter.api.Test;
import util.ArrayUtil;

public class OccurrencesAfterBigramTest {
	OccurrencesAfterBigram test = new OccurrencesAfterBigram();
	
	@Test
	public void findOcurrences() {
		ArrayUtil.prettyPrint(test.findOcurrences("a good alice is a good girl she is a good student", "a", "good"));
	}
	
	
}