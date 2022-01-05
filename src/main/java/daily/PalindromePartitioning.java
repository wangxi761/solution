package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        rec(s, res, new ArrayList<>(), 0);
        return res;
    }

    public void rec(String s, List<List<String>> res, List<String> temp, int index) {
        if (temp.size() > 0 && index == s.length()) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                rec(s, res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(partition("aab").toString());
        System.out.println(partition("a").toString());

    }
}
