package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/">leetcode2517</a>
 */
public class LtCode2517 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //8, 1 2 5 8 13 21
        System.out.println(solution.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
        //2, 1 1 3
        System.out.println(solution.maximumTastiness(new int[]{1, 3, 1}, 2));
        //0, 7 7 7 7
        System.out.println(solution.maximumTastiness(new int[]{7, 7, 7, 7}, 2));
    }

    static class Solution {
        public int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            int left = 0, right = price[price.length - 1] - price[0], ans = 0;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (check(price, k, mid)) {
                    ans = Math.max(ans, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }

        private boolean check(int[] price, int k, int targetSweet) {
            int ans = 1, pre = price[0];
            for (int index = 1; index < price.length; index++) {
                if (price[index] - pre >= targetSweet) {
                    pre = price[index];
                    ans++;
                }
            }
            return ans >= k;
        }
    }
}
