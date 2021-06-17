package bit;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public int countTriplets(int[] arr) {
        int res = 0;
        for (int start = 0; start < arr.length; start++) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int end = start + 1; end < arr.length; end++) {
                int sum = 0;
                if (cache.containsKey(end)) {
                    sum = cache.get(end);
                } else {
                    for (int i = start; i <= end; i++) {
                        sum ^= arr[i];
                    }
                    cache.put(end, sum);
                }
                if (sum == 0) {
                    res+=end-start;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, countTriplets(new int[]{2, 3, 1, 6, 7}));
        assertEquals(10, countTriplets(new int[]{1, 1, 1, 1, 1}));
        assertEquals(0, countTriplets(new int[]{2, 3}));
        assertEquals(3, countTriplets(new int[]{1, 3, 5, 7, 9}));
        assertEquals(8, countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }
}