package topic.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            else if (candidates[i] == target) {
                list.add(Collections.singletonList(candidates[i]));
                break;
            }else {
                for (List<Integer> integers : combinationSum(Arrays.copyOfRange(candidates,i,candidates.length),target-candidates[i])) {
                	List<Integer> li=new ArrayList<>();
                	li.addAll(integers);
                	li.add(candidates[i]);
                	list.add(li);
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] array={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(array,target));
    }
}
