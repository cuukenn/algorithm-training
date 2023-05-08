package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/?envType=study-plan-v2&id=top-interview-150">leetcode209</a>
 */
public class LtCode209 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //2
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        //1
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));
        //0
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        //3
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        //3
        System.out.println(solution.minSubArrayLen(6, new int[]{10, 2, 3}));
    }

    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int start = 0, end = 0, sum = 0, minWind = Integer.MAX_VALUE;
            while (end < nums.length) {
                sum += nums[end];
                while (sum >= target) {
                    minWind = Math.min(minWind, end - start + 1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return minWind == Integer.MAX_VALUE ? 0 : minWind;
        }
    }
}
