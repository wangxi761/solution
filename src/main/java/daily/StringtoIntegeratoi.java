package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringtoIntegeratoi {
    public int myAtoi(String s) {
        char[] ch = s.toCharArray();
        int index = 0, len = s.length();
        while (index < len && !(Character.isDigit(ch[index]) || ch[index] == '+' || ch[index] == '-')) {
            if (ch[index] != ' ') {
                return 0;
            }
            index++;
        }
        if (index >= len) {
            return 0;
        }
        int op = 1;
        if (ch[index] == '+' || ch[index] == '-') {
            op = ch[index] == '-' ? -1 : 1;
            index++;
        }
        int sum = 0;
        while (index < len && Character.isDigit(ch[index])) {
            int tmp = sum * 10 + (ch[index] - '0');
            if (tmp / 10 != sum) {
                return op == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            sum = tmp;
            index++;
        }
        return sum * op;
    }

    @Test
    public void test() {
        Assertions.assertEquals(-2147483648, myAtoi("-6147483648"));
        Assertions.assertEquals(42, myAtoi("42"));
        Assertions.assertEquals(-42, myAtoi("   -42"));
        Assertions.assertEquals(4193, myAtoi("4193 with words"));
    }
}
