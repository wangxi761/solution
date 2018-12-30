package contest;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidMountainArray_941 {
	public boolean validMountainArray(int[] A) {
		if(A.length<3) {
			return false;
		}
		int i=0;
		while (i<A.length-1&&A[i]<A[i+1]) {
			i++;
		}
		if(i==A.length-1||i==0)
			return false;
		while(i<A.length-1&&A[i]>A[i+1])
			i++;
		if(i==A.length-1)
			return true;
		return false;
	}
	@Test
	public void test() throws Exception {
		int[] A= {3,2,1};
		boolean validMountainArray = validMountainArray(A);
		assertEquals(true, validMountainArray);
	}
}
