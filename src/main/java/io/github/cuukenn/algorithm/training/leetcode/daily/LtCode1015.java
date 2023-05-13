package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/smallest-integer-divisible-by-k/">leetcode1015</a>
 */
public class LtCode1015 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //1
        System.out.println(solution.smallestRepunitDivByK(1));
        //-1
        System.out.println(solution.smallestRepunitDivByK(2));
        //3
        System.out.println(solution.smallestRepunitDivByK(3));
    }

    static class Solution {
        public int smallestRepunitDivByK(int K) {
            if (K % 2 == 0 || K % 5 == 0) {
                return -1;
            }
            int i = 1;
            for (int n = 1; n % K != 0; i++) {
                n %= K;
                n = n * 10 + 1;
            }
            return i;
        }
    }
}
