package bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XOROperationinanArray {
    public int xorOperation(int n, int start) {
        int res=0;
        for (int i = 0; i < n; i++) {
            res = res ^ (start + 2 * i);
        }
        return res;
    }

    @Test
    public void test() {
        Assertions.assertEquals(8,xorOperation(5,0));
        Assertions.assertEquals(8,xorOperation(4,3));
        Assertions.assertEquals(7,xorOperation(1,7));
        Assertions.assertEquals(2,xorOperation(10,5));
    }
}
