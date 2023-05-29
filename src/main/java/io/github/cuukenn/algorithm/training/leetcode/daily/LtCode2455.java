package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/">leetcode2455</a>
 */
public class LtCode2455 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.averageValue(new int[]{1, 3, 6, 10, 12, 15}));
        System.out.println(solution.averageValue(new int[]{1, 2, 4, 7, 10}));
    }

    static class Solution {
        public int averageValue(int[] nums) {
            long sum = 0, count = 0;
            for (int num : nums) {
                if (num % 3 != 0 || num % 2 != 0) {
                    continue;
                }
                sum += num;
                count++;
            }
            if (count <= 0) {
                return 0;
            }
            return (int) (sum / count);
        }
    }
}
