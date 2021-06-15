package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
    }

    @Test
    public void test() {
		Assertions.assertEquals(2,hammingDistance(1,4));
		Assertions.assertEquals(1,hammingDistance(3,1));
    }
}
			