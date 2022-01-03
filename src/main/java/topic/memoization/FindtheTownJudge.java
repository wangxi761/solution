package topic.memoization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FindtheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] c = new int[n];
        for (int[] judge : trust) {
            assert judge.length == 2;
            c[judge[1] - 1]++;
            c[judge[0] - 1]--;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] == n - 1 ) {
                return i + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, findJudge(2, new int[][]{{1, 2}}));
        Assertions.assertEquals(3, findJudge(3, new int[][]{{1, 3}, {2, 3}}));
        Assertions.assertEquals(-1, findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}));
    }
}
