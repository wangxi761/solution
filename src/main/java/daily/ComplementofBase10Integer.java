package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComplementofBase10Integer {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int sum = 0, base = 1;
        while (n != 0) {
            sum += (n % 2 == 0 ? 1 : 0) * base;
            base = base * 2;
            n = n / 2;
        }
        return sum;
    }

    @Test
    public void test() {
        Assertions.assertEquals(2, bitwiseComplement(5));
        Assertions.assertEquals(0, bitwiseComplement(7));
        Assertions.assertEquals(5, bitwiseComplement(10));
    }
}
