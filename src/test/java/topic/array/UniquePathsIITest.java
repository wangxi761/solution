package topic.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsIITest {

    @Test
    public void uniquePathsWithObstacles() {

        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        UniquePathsII uniquePathsII = new UniquePathsII();
        int i = uniquePathsII.uniquePathsWithObstacles(arr);
        assertEquals(2, i);
    }
}