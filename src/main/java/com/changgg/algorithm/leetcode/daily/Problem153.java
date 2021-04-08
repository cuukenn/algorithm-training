package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem153
 * @Description https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/submissions/
 * @Date 2021/4/8 19:09
 */
public class Problem153 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int start, int end) {
        if (end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }
        if (end == start) {
            return nums[start];
        }
        int midIndex = start + ((end - start) >> 1);
        int left = nums[start], mid = nums[midIndex], right = nums[end];
        if (left <= mid) {
            if (left <= right) {
                return findMin(nums, start, midIndex);
            } else {
                return findMin(nums, midIndex, end);
            }
        } else {
            return findMin(nums, start, midIndex);
        }
    }


    public static void main(String[] args) {
        Problem153 problem153 = new Problem153();
        int[] nums = new int[]{3, 4, 5, 1, 2};
        System.out.println(problem153.findMin(nums));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        System.out.println(problem153.findMin(nums));
        nums = new int[]{11, 13, 15, 17};
//        System.out.println(problem153.findMin(nums));
        nums = new int[]{11, 13, 13, 15, 15, 17};
//        System.out.println(problem153.findMin(nums));
        nums = new int[]{1, 2};
        System.out.println(problem153.findMin(nums));
        nums = new int[]{1};
        System.out.println(problem153.findMin(nums));
        nums = new int[]{0};
        System.out.println(problem153.findMin(nums));
    }
}
