package topic.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if(i>0&&candidates[i]==candidates[i-1]) continue;
            if (candidates[i] > target) {
                break;
            } else if (candidates[i] == target) {
                result.add(Collections.singletonList(candidates[i]));
            } else {
                for (List<Integer> j : combinationSum2(Arrays.copyOfRange(candidates, i + 1, candidates.length), target - candidates[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.addAll(j);
                    list.add(candidates[i]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    @Test
    public void combinationSum2() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
