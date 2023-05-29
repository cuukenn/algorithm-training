package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/letter-tile-possibilities/">leetcode1079</a>
 */
public class LtCode1079 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTilePossibilities("AAB"));
        System.out.println(solution.numTilePossibilities("AAABBC"));
        System.out.println(solution.numTilePossibilities("V"));
    }

    static class Solution {
        public int numTilePossibilities(String tiles) {
            final Set<Character> titleChars = new HashSet<>();
            final Map<Character, Integer> titleChar2count = new HashMap<>(tiles.length());
            for (char titleChar : tiles.toCharArray()) {
                titleChars.add(titleChar);
                titleChar2count.put(titleChar, titleChar2count.getOrDefault(titleChar, 0) + 1);
            }
            return dfs(titleChar2count, titleChars, tiles.length()) - 1;
        }

        private int dfs(Map<Character, Integer> titleChar2count, Set<Character> titleChars, int n) {
            if (n == 0) {
                return 1;
            }
            int rs = 1;
            for (char titleChar : titleChars) {
                if (titleChar2count.get(titleChar) > 0) {
                    titleChar2count.put(titleChar, titleChar2count.get(titleChar) - 1);
                    rs += dfs(titleChar2count, titleChars, n - 1);
                    titleChar2count.put(titleChar, titleChar2count.get(titleChar) + 1);
                }
            }
            return rs;
        }
    }
}
