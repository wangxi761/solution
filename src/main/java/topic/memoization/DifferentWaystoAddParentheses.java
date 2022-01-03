package topic.memoization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        Set<Integer> res = new HashSet<>();

        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        int i = 0;
        int len = expression.length();
        while (i < len) {
            StringBuilder sb = new StringBuilder();
            int j = i;
            while (j < len && Character.isDigit(expression.charAt(j))) {
                sb.append(expression.charAt(j));
                j++;
            }
            nums.add(Integer.parseInt(sb.toString()));
            if (j < len) {
                ops.add(expression.charAt(j++));
            }
            i = j;
        }
        return compute(nums, ops, 0, nums.size() - 1);
    }
    public List<Integer> compute(List<Integer> nums, List<Character> ops) {
        List<Integer>[][] dp=new ArrayList[nums.size()][nums.size()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
            }
        }

        for (int i = 0; i < nums.size(); i++) {

        }

        return null;
    }

    public List<Integer> compute(List<Integer> nums, List<Character> ops, int left, int right) {
        List<Integer> res = new ArrayList<>();
        if (left == right) {
            res.add(nums.get(left));
            return res;
        }
        for (int i = left; i < right; i++) {
            List<Integer> ls = compute(nums, ops, left, i);
            List<Integer> rs = compute(nums, ops, i + 1, right);
            Character op = ops.get(i);
            for (Integer l : ls) {
                for (Integer r : rs) {
                    res.add(calc(l, r, op));
                }
            }
        }
        return res;
    }

    private int calc(int lnum, int rnum, Character op) {
        switch (op) {
            case '+':
                return lnum + rnum;
            case '-':
                return lnum - rnum;
            case '*':
                return lnum * rnum;
        }
        return 0;
    }


    @Test
    public void test() {
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

}
