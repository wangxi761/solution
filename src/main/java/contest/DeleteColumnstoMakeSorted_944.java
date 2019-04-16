package contest;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteColumnstoMakeSorted_944 {
	public int minDeletionSize(String[] A) {
		if(A.length==0) {
			return 0;
		}
		int result=0;
		int count=A[0].length();
		OUTER:for (int i = 0; i < count; i++) {
			char c='a';
			for (int j = 0; j < A.length; j++) {
				if(c>A[j].charAt(i)) {
					result++;
					continue OUTER;
				}
				c=A[j].charAt(i);
			}
		}
		return result;
	}
	@Test
	public void test() throws Exception {
		String[] A= {"cba","daf","ghi"};
		int minDeletionSize = minDeletionSize(A);
		assertEquals(1, minDeletionSize);
	}
}
