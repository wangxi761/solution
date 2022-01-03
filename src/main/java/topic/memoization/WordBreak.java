package topic.memoization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict));
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i + 1; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    @Test
    public void test() {
        Assertions.assertTrue(wordBreak("cars", List.of("car", "ca", "rs")));
        Assertions.assertTrue(wordBreak("leetcode", List.of("leet", "code")));
        Assertions.assertTrue(wordBreak("applepenapple", List.of("apple", "pen")));
        Assertions.assertFalse(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
