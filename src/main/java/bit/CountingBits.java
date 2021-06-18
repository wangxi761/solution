package bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountingBits {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0,1,1},countBits(2));
        assertArrayEquals(new int[]{0,1,1,2,1,2},countBits(5));
    }
}