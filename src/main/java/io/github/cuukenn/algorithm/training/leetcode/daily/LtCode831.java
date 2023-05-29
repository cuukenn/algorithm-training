package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.regex.Pattern;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/masking-personal-information/">leetcode831</a>
 */
public class LtCode831 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maskPII("LeetCode@LeetCode.com"));
        System.out.println(solution.maskPII("AB@qq.com"));
        System.out.println(solution.maskPII("1(234)567-890"));
    }

    static class Solution {
        private static final Pattern EMAIL = Pattern.compile("");
        private static final Pattern TEL = Pattern.compile("");

        public String maskPII(String s) {
            return null;
        }
    }
}
