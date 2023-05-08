package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/valid-palindrome/?envType=study-plan-v2&id=top-interview-150">leetcode125</a>
 */
public class LtCode125 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(" "));
        System.out.println(solution.isPalindrome("0P"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            //pre optimizer
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                    continue;
                }
                stringBuilder.append(c);
            }
            char[] optimizerChar = stringBuilder.toString().toLowerCase().toCharArray();
            int startIndex = 0, endIndex = optimizerChar.length - 1;
            while (startIndex < endIndex) {
                if (optimizerChar[startIndex++] != optimizerChar[endIndex--]) {
                    return false;
                }
            }
            return true;
        }
    }
}
