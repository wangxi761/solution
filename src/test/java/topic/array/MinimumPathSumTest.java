package topic.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinimumPathSumTest {

    @Test
    public void minPathSum() {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int i = minimumPathSum.minPathSum(arr);
        assertEquals(7, i);
    }
}