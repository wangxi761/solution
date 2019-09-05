package topic.heap;

import org.junit.Test;
import util.ArrayUtil;

public class KthSmallestElementinaSortedMatrixTest {
	KthSmallestElementinaSortedMatrix test = new KthSmallestElementinaSortedMatrix();
	
	@Test
	public void kthSmallestTest() {
		int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
		System.out.println(test.kthSmallest(matrix, 8));
	}
	@Test
	public void diagonal() {
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
	
	@Test
	public void count() {
		int n = 8;
		int[][] arr = new int[2 * n - 1][3];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = i + 1;
			arr[i][1] = i + 1 > n ? 2 * n - i - 1 : i + 1;
			arr[i][2] = sum += i;
		}
		ArrayUtil.prettyPrint(arr);
	}
}