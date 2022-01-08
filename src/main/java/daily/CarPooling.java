package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }
        for (Integer value : arr) {
            if (capacity < 0) {
                return false;
            }
            capacity -= value;
        }
        return capacity > 0;
    }

    @Test
    public void test() {
        Assertions.assertFalse(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        Assertions.assertTrue(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        Assertions.assertTrue(carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
    }

}
