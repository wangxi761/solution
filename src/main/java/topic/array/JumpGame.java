package topic.array;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int cur=0;
        for (int i = 0; i < nums.length; i++) {
            if(i>cur||cur>= nums.length-1) break;
            cur=Math.max(i+nums[i],cur);
        }
        return cur>=nums.length-1;
    }

    @Test
    public void canJumpTest() {
        int[] arr={2,3,1,1,4};
        boolean b = canJump(arr);
        assertTrue(b);
    }
}
