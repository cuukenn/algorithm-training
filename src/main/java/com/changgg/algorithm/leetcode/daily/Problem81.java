package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem81
 * @Description https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/submissions/
 * @Date 2021/4/7 19:31
 */
public class Problem81 {
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    public boolean search(int[] nums, int target, int start, int end) {
        if (end < start) {
            return false;
        }
        int mid = start + ((end - start) >> 1);
        if (nums[mid] == target) {
            return true;
        }
        if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
            return search(nums, target, start + 1, end - 1);
        } else if (nums[start] <= nums[mid]) {
            if (nums[start] <= target && target < nums[mid]) {
                return search(nums, target, start, mid - 1);
            } else {
                return search(nums, target, mid + 1, end);
            }
        } else {
            if (nums[mid] <= target && target <= nums[end]) {
                return search(nums, target, mid + 1, end);
            } else {
                return search(nums, target, start, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        Problem81 problem81 = new Problem81();
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
//        System.out.println(problem81.search(nums, 0));
        nums = new int[]{2, 5, 6, 0, 0, 1, 2};
//        System.out.println(problem81.search(nums, 3));
//        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
//        System.out.println(problem81.search(nums, 2));
        nums = new int[]{3, 1};
        System.out.println(problem81.search(nums, 1));
    }
}
