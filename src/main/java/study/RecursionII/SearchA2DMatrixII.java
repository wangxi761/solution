package study.RecursionII;

public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int i = matrix.length - 1, j = 0;
		while (i >= 0 && j < matrix[0].length) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				i--;
			} else {
				j++;
			}
		}
		return false;
	}
	
	
	public boolean searchMatrix1(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int top_left = 0, top_right = matrix[0].length - 1;
		while (top_left <= top_right) {
			int mid = (top_right - top_left) / 2 + top_left;
			if (target < matrix[0][mid]) {
				top_right = mid - 1;
			} else {
				top_left = mid + 1;
			}
		}
		
		int left_left = 0, left_right = matrix.length - 1;
		while (left_left <= left_right) {
			int mid = (left_right - left_left) / 2 + left_left;
			if (target < matrix[mid][0]) {
				left_right = mid - 1;
			} else {
				left_left = mid + 1;
			}
		}
		
		for (int i = 0; i < left_left; i++) {
			for (int j = 0; j < top_left; j++) {
				if (matrix[i][j] == target) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int binarySearch(int[] arr, int target) {
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			int mid = (j - i) / 2 + i;
			if (target < arr[mid]) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		return i;
	}
}
