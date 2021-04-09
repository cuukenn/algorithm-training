package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem154
 * @Description https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/
 * @Date 2021/4/9 18:46
 */
public class Problem154 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int start, int end) {
        while (start < end && nums[start] == nums[start + 1]) {
            start++;
        }
        while (start < end && nums[end] == nums[end - 1]) {
            end--;
        }
        if (end - start == 1) {
            return Math.min(nums[start], nums[end]);
        }
        if (end == start) {
            return nums[start];
        }
        int midIndex = start + ((end - start) >> 1);
        int left = nums[start], mid = nums[midIndex], right = nums[end];
        if (left <= mid) {
            if (left == right) {
                return findMin(nums, midIndex, end);
            } else if (left < right) {
                return findMin(nums, start, midIndex);
            } else {
                return findMin(nums, midIndex, end);
            }
        } else {
            return findMin(nums, start, midIndex);
        }
    }

    public static void main(String[] args) {
        Problem154 problem154 = new Problem154();
        int[] nums = new int[]{1, 3, 5};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{2, 2, 2, 0, 1};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{3, 3, 1, 3};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{3, 4, 5, 1, 2};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{11, 13, 15, 17};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{11, 13, 13, 15, 15, 17};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{1, 2};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{1};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{0};
//        System.out.println(problem154.findMin(nums));
        nums = new int[]{1, 2, 2, 2, 0, 1, 1};
        System.out.println(problem154.findMin(nums));
        nums = new int[]{1, 2, 0, 1, 1};
        System.out.println(problem154.findMin(nums));
    }
}
