package leetcode.problems.two_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (cache.containsKey(current)) {
                return new int[]{i, cache.get(current)};
            } else {
                cache.put(target - current, i);
            }
        }
        return null;
    }
}