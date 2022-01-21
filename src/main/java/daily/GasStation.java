package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumG=0,sumC=0,start=0,cur=0;

        for (int i = 0; i < gas.length; i++) {
            sumG += gas[i];
            sumC += cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                start = i + 1;
                cur=0;
            }
        }
        return sumG < sumC ? -1 : start;
    }


    public int canCompleteCircuit_bad_case(int[] gas, int[] cost) {

        LOOP:
        for (int i = 0; i < gas.length; i++) {
            int sum = 0;
            int count = 0;
            int index = i;
            while (count != gas.length) {
                sum += gas[index];
                sum -= cost[index];
                if (sum < 0) continue LOOP;
                count++;
                index = (index + 1) % gas.length;
            }
            return i;
        }
        return -1;
    }

    @Test
    public void test() {
        Assertions.assertEquals(3, canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Assertions.assertEquals(-1, canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

}
