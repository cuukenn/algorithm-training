package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.BitSet;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/count-the-number-of-consistent-strings/submissions">leetcode1684</a>
 */
public class LtCode1684 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"}));
        System.out.println(solution.countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"}));
        System.out.println(solution.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }

    static class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            BitSet bitSet = new BitSet(allowed.length());
            for (char c : allowed.toCharArray()) {
                bitSet.set(c);
            }
            int cn = 0;
            for (String word : words) {
                boolean flag = true;
                for (char c : word.toCharArray()) {
                    if (!bitSet.get(c)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cn++;
                }
            }
            return cn;
        }
    }
}
