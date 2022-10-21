package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/">leetcode</a>
 */
public class Problem122 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static class Solution {

        public int maxProfit(int[] prices) {
            int rs = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    rs += prices[i] - prices[i - 1];
                }
            }
            return rs;
        }
    }
}
