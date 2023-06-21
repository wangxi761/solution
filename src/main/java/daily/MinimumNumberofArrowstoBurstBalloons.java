package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumNumberofArrowstoBurstBalloons {


    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int sum = 0, count = 0;
        for (int[] point : points) {
            if (count == 0 || point[0] > sum) {
                count++;
                sum = point[1];
            }
        }
        return count;
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        Assertions.assertEquals(4, findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        Assertions.assertEquals(2, findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));

    }
}
