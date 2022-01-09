package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotBoundedInCircle {


    public boolean isRobotBounded(String instructions) {
        int[] pos = {0, 0};
        int[] direction = new int[]{0, 1, 2, 3};
        int curDirection = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                curDirection = direction[(curDirection + 3) % 4];
            } else if (c == 'R') {
                curDirection = direction[(curDirection + 1) % 4];
            } else {
                if (curDirection == 0) {
                    pos[1]++;
                } else if (curDirection == 1) {
                    pos[0]++;
                } else if (curDirection == 2) {
                    pos[1]--;
                } else {
                    pos[0]--;
                }
            }
        }
        return (pos[0] == 0 && pos[1] == 0) || (curDirection != 0);
    }

    @Test
    public void test() {
        Assertions.assertTrue(isRobotBounded("GGLLGG"));
        Assertions.assertFalse(isRobotBounded("GG"));
        Assertions.assertTrue(isRobotBounded("GL"));
    }

}
