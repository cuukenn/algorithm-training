package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem456
 * @Description https://leetcode-cn.com/problems/132-pattern/
 * @Date 2021/3/24 20:20
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int leftMin = nums[0];
        for (int j = 0; j < nums.length; j++) {
            int current = nums[j];
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] >= nums[j]) {
                    continue;
                }
                if (leftMin < nums[k]) {
                    return true;
                }
            }
            leftMin = Math.min(current, leftMin);
        }
        return false;
    }


    public static void main(String[] args) {
        Problem456 problem456 = new Problem456();
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(problem456.find132pattern(nums));
        nums = new int[]{3, 1, 4, 2};
        System.out.println(problem456.find132pattern(nums));
        nums = new int[]{-1, 3, 2, 0};
        System.out.println(problem456.find132pattern(nums));
        nums = new int[]{1, 0, 1, -4, -3};
        System.out.println(problem456.find132pattern(nums));
    }
}
