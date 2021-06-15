package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        int res = 0;
        while (n >= k) {
            res += n % k;
            n = n / k;
        }
        return res + n;

    }

    @Test
    public void test() {
        Assertions.assertEquals(9, sumBase(34, 6));
        Assertions.assertEquals(1, sumBase(10, 10));
    }

}
