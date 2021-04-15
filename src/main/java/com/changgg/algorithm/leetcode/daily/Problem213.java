package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem213
 * @Description https://leetcode-cn.com/problems/house-robber-ii/
 * @Date 2021/4/15 19:53
 */
public class Problem213 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robP(nums, 0, nums.length - 2), robP(nums, 1, nums.length - 1));
    }

    private int robP(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        Problem213 problem213 = new Problem213();
        int[] nums = new int[]{2, 3, 2};
        System.out.println(problem213.rob(nums));
        nums = new int[]{1, 2, 3, 1};
        System.out.println(problem213.rob(nums));
    }
}
