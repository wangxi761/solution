package topic.array;

import org.junit.jupiter.api.Test;

public class SearchA2DMatrixTest {

    @Test
    public void searchMatrix() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
//        assertTrue(searchA2DMatrix.searchMatrix(matrix,3));
//        assertTrue(searchA2DMatrix.searchMatrix(matrix1,11));
//        assertFalse(searchA2DMatrix.searchMatrix(matrix1,13));
//        searchA2DMatrix.searchMatrix(new int[][]{{1}},0);
        searchA2DMatrix.searchMatrix(new int[][]{{1, 3}}, 2);
//        assertFalse(lower_bound(new int[]{1,3},2));
    }


    public boolean binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int tmp = arr[mid];
            if (tmp == target)
                return true;
            else if (tmp > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
}