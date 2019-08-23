package topic.hashtable;

import org.junit.Test;
import util.ArrayUtil;

public class SetMismatchTest {
	SetMismatch test = new SetMismatch();
	
	@Test
	public void findErrorNums() {
		ArrayUtil.prettyPrint(test.findErrorNums(new int[]{3, 2, 2}));
	}
}