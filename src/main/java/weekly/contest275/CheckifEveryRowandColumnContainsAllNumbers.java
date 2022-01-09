package weekly.contest275;

import java.util.HashSet;
import java.util.Set;

public class CheckifEveryRowandColumnContainsAllNumbers {
    public boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                row.add(matrix[i][j]);
                col.add(matrix[j][i]);
            }
            if (row.size() != matrix.length || col.size() != matrix.length) {
                return false;
            }
        }
        return true;
    }
}
