package topic.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsTest {

    @Test
    public void uniquePaths() {
        UniquePaths uniquePaths = new UniquePaths();
        int i = uniquePaths.uniquePaths(3, 2);
        int j = uniquePaths.uniquePaths(7, 3);
        assertEquals(3, i);
        assertEquals(28, j);
    }
}