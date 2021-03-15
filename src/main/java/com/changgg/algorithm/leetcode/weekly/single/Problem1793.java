package com.changgg.algorithm.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem1793
 * @Description https://leetcode-cn.com/contest/weekly-contest-232/problems/maximum-score-of-a-good-subarray/
 * @Date 2021/3/15 20:12
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1793 {
    public int maximumScore(int[] nums, int k) {
        int left = k, right = k;
        int rs = 0;
        for (int val = nums[k]; val > 0; val--) {
            while (left - 1 >= 0 && nums[left - 1] >= val) {
                left--;
            }
            while (right + 1 < nums.length && nums[right + 1] >= val) {
                right++;
            }
            rs = Math.max(rs, val * (right - left + 1));
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem1793 problem1793 = new Problem1793();
        int[] nums = new int[]{1, 4, 3, 7, 4, 5};
        System.out.println(problem1793.maximumScore(nums, 3));
        nums = new int[]{5, 5, 4, 5, 4, 1, 1, 1};
        System.out.println(problem1793.maximumScore(nums, 0));
        nums = new int[]{6569, 9667, 3148, 7698, 1622, 2194, 793, 9041, 1670, 1872};
        System.out.println(problem1793.maximumScore(nums, 5));
    }
}
