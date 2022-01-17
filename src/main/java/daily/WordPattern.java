package daily;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> cache = new HashMap<>();
        char[] ch = pattern.toCharArray();
        boolean flag = true;
        for (int i = 0; i < ch.length; i++) {
            if (cache.containsKey(ch[i])) {
                flag = flag && Objects.equals(cache.get(ch[i]), strs[i]);
            } else {
                cache.put(ch[i], strs[i]);
            }
        }
        return flag && new HashSet<>(cache.values()).size() == cache.size();
    }

    @Test
    public void test() {
        Assertions.assertTrue(wordPattern("abba", "dog cat cat dog"));
        Assertions.assertFalse(wordPattern("abba", "dog cat cat fish"));
        Assertions.assertFalse(wordPattern("aaaa", "dog cat cat dog"));
        Assertions.assertFalse(wordPattern("abba", "dog dog dog dog"));
    }
}
