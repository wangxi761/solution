package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        int sum = n % k;
        int res = n / k;
        while (res > 9) {
            sum += res % 10;
            res = res / 10;
        }
        return sum + res;
    }

    @Test
    public void test() {
        Assertions.assertEquals(9, sumBase(34, 6));
        Assertions.assertEquals(1, sumBase(10, 10));
    }
}
