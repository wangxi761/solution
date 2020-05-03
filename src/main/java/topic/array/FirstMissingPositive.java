package topic.array;


import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i : nums) {
            sets.add(i);
        }
        int i = 1;
        while (true) {
            if (!sets.contains(i))
                break;
            else
                i++;
        }
        return i;
    }

    @Test
    public void firstMissingPositive1() {
        int[] arr = {1, 2, 0};
        int i = firstMissingPositive(arr);
        System.out.println(i);

    }
}
