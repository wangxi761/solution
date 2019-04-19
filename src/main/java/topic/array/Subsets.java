package topic.array;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(result.get(j));
                result.add(list);
            }
        }
        return result;
    }
}
