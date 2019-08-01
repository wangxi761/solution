package topic.sort;

import org.junit.Test;
import util.ArrayUtil;

public class SortArrayByParityIITest {
	SortArrayByParityII test = new SortArrayByParityII();
	
	@Test
	public void sortArrayByParityII() {
		ArrayUtil.prettyPrint(test.sortArrayByParityII(new int[]{4, 2, 5, 7}));
	}
}