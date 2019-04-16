package topic.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int height = matrix.length;
		int width = matrix[0].length;
		int[][] img = new int[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				img[j][height - i - 1] = matrix[i][j];
			}
		}
		matrix = img;
		printMatrix(matrix);
	}

	public void printMatrix(int[][] matrix) {
		Arrays.stream(matrix).forEach(i -> System.out.println(Arrays.toString(i)));
	}

	public void rotate2(int[][] matrix) {
		int height = matrix.length;
		int width = matrix[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (i < j)
					continue;
				int t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		}
		for (int i = 0; i < height; i++) {
			int a=0,b=width-1;
			while(a<b) {
				int t=matrix[i][a];
				matrix[i][a]=matrix[i][b];
				matrix[i][b]=t;
				a++;b--;
			}
		}
		printMatrix(matrix);
	}

	@Test
	public void test() throws Exception {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 } };
		rotate(matrix);
	}

}
