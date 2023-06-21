package daily;

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int speed = 0;
            for (int pile : piles) {
                speed += Math.ceil((double) pile / mid);
            }
            if (speed <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
