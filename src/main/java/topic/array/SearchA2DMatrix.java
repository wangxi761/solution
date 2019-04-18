package topic.array;

public class SearchA2DMatrix {
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m - 1, mid = (lo + hi) / 2;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }


        int index = Math.min(hi, lo) < 0 ? 0 : Math.min(hi, lo);
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (matrix[index][mid] == target)
                return true;
            else if (matrix[index][mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (matrix[mid / n][mid % n] == target)
                return true;
            else if (matrix[mid / n][mid % n] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
}