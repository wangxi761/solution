package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int[] left = new int[seats.length];
        int[] right = new int[seats.length];


        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                left[i] = i - 1 < 0 ? Integer.MAX_VALUE : left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 0) {
                right[i] = i + 1 >= seats.length ? Integer.MAX_VALUE : right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < seats.length; i++) {
            max = Math.max(max, Math.min(left[i], right[i]));
        }
        return max;
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        Assertions.assertEquals(3, maxDistToClosest(new int[]{1, 0, 0, 0}));
        Assertions.assertEquals(1, maxDistToClosest(new int[]{0, 1}));
    }

}
