package topic.memoization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanIWin {


    public static class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (desiredTotal <= 0) {
                return true;
            }
            int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
            if (sum < desiredTotal) {
                return false;
            }
            if (sum == desiredTotal) {
                return maxChoosableInteger % 2 != 0;
            }
            int[] dp = new int[1 << maxChoosableInteger];
            return dfs(maxChoosableInteger, desiredTotal, 0, dp);
        }

        public boolean dfs(int max, int total, int index, int[] dp) {
            if (total <= 0) return false;
            if (dp[index] != 0) return dp[index] == 1;
            boolean win = false;
            for (int i = 0; i < max; i++) {
                if ((index & (1 << i)) == 0) {
                    win = win || !dfs(max, total - i - 1, index ^ (1 << i), dp);
                }
            }
            dp[index] = win ? 1 : -1;
            return win;
        }

        @Test
        public void test() {
            Assertions.assertFalse(canIWin(10, 11));
            Assertions.assertTrue(canIWin(10, 0));
            Assertions.assertTrue(canIWin(10, 1));
        }
    }

}
