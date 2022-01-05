package topic.memoization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerReplacement {
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        int sum = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                sum++;
            } else {
                sum++;
                int np = n + 1;
                int nm = n - 1;

                int np_c = 0, nm_c = 0;
                while (np % 2 == 0 && np >= 1) {
                    np /= 2;
                    np_c++;
                }
                while (nm % 2 == 0 && nm >= 1) {
                    nm /= 2;
                    nm_c++;
                }
                if (np > nm) {
                    n = nm;
                    sum += nm_c;
                } else if (np < nm) {
                    n = np;
                    sum += np_c;
                } else {
                    n=np;
                    sum += Math.min(nm_c, np_c);
                }
            }
        }
        return sum;
    }


    @Test
    public void test() {
        Assertions.assertEquals(2, integerReplacement(3));
        Assertions.assertEquals(17, integerReplacement(65535));
        Assertions.assertEquals(3, integerReplacement(8));
        Assertions.assertEquals(4, integerReplacement(7));
        Assertions.assertEquals(2, integerReplacement(4));
    }
}
