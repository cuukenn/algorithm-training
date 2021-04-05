package com.changgg.algorithm.leetcode.weekly.doubleWk;

import java.util.Arrays;

/**
 * @author changgg
 * @Classname Problem1784
 * @Description https://leetcode-cn.com/problems/4xy4Wx/
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem4xy4Wx {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1000000007, result = 0, left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + right - left) % mod;
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem4xy4Wx problem4xy4Wx = new Problem4xy4Wx();
        int[] nums = new int[]{2, 5, 3, 5};
        System.out.println(problem4xy4Wx.purchasePlans(nums, 6));
        nums = new int[]{2, 2, 1, 9};
        System.out.println(problem4xy4Wx.purchasePlans(nums, 10));
    }
}
