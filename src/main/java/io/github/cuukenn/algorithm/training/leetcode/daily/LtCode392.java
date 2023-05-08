package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/is-subsequence/?envType=study-plan-v2&id=top-interview-150">leetcode392</a>
 */
public class LtCode392 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
        System.out.println(solution.isSubsequence("", "ahbgdc"));
        System.out.println(solution.isSubsequence("b", "abc"));
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }
            char[] subChars = s.toCharArray(), patternChars = t.toCharArray();
            for (int index = 0; index < patternChars.length; index++) {
                int subIndex = 0, patternIndex = index;
                while (subIndex < s.length() && patternIndex < t.length()) {
                    if (subChars[subIndex] == patternChars[patternIndex]) {
                        subIndex++;
                    }
                    patternIndex++;
                }
                if (subIndex >= s.length()) {
                    return true;
                }
            }
            return false;
        }
    }
}
