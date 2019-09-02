package topic.heap;

import org.junit.Test;
import util.ArrayUtil;

public class KthSmallestElementinaSortedMatrixTest {
	KthSmallestElementinaSortedMatrix test = new KthSmallestElementinaSortedMatrix();
	
	@Test
	public void kthSmallest() {
		int n = 5;
		int[][] m = new int[n][n];
		int count = 0;
		for (int t = 0; t < m.length * 2 - 1; t++) {
			for (int i = 0; i <= t; i++) {
				int j = t - i;
				if (i > n - 1 || j > n - 1) continue;
				m[i][j] = count++;
			}
		}
		ArrayUtil.prettyPrint(m);
	}
}