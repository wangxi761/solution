package topic.array;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int top = 0, left = 0, bottom = n - 1, right = n - 1;
        int i = 1;
        while (i <= n * n) {
            for (int j = left; j <= right; j++) {
                arr[top][j] = i++;
            }
            top++;

            for (int j = top; j <= bottom; j++) {
                arr[j][right] = i++;
            }
            right--;

            if(top<=bottom){
                for (int j = right; j >= left; j--) {
                    arr[bottom][j]=i++;
                }
            }
            bottom--;

            if(left<=right){
                for (int j=bottom;j>=top;j--){
                    arr[j][left]=i++;
                }
            }
            left++;
        }
        return arr;
    }
}
