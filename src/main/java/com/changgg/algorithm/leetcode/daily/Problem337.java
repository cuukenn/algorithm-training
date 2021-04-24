package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem337
 * @Description https://leetcode-cn.com/problems/combination-sum-iv/
 * @Date 2021/4/24 19:43
 */
public class Problem337 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        //组合和为0的组合数为1
        dp[0] = 1;
        //动态规划，最终状态转移到dp[target]
        for (int curTarget = 1; curTarget <= target; curTarget++) {
            for (int num : nums) {
                if (curTarget >= num) {
                    dp[curTarget] += dp[curTarget - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Problem337 problem337 = new Problem337();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(problem337.combinationSum4(nums, 4));
    }
}
