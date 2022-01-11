package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddBinary {
    public String addBinary(String a, String b) {
        char[] ach = a.toCharArray();
        char[] bch = b.toCharArray();
        int i = ach.length - 1, j = bch.length - 1;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            c = add(sb, c, ach[i--] - '0', bch[j--] - '0');
        }
        while (i >= 0) {
            c = add(sb, c, ach[i--] - '0', 0);
        }
        while (j >= 0) {
            c = add(sb, c, bch[j--] - '0', 0);
        }
        if (c == 1) {
            sb.insert(0, c);
        }
        return sb.toString();
    }

    public int add(StringBuilder sb, int c, int a, int b) {
        int sum = a + b + c;
        if (sum > 1) {
            sum = sum - 2;
            sb.insert(0, sum);
            return 1;
        } else {
            sb.insert(0, sum);
            return 0;
        }
    }

    @Test
    public void test() {
        Assertions.assertEquals("100", addBinary("11", "1"));
        Assertions.assertEquals("10101", addBinary("1010", "1011"));

    }
}
