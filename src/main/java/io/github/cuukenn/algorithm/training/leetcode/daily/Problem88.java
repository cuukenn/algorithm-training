package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;

/**
 * @author changgg
 * @Classname Problem88
 * @Description https://leetcode-cn.com/problems/merge-sorted-array/submissions/
 * @Date 2021/4/5 13:33
 */
public class Problem88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] > nums2[index2]) {
                result[index] = nums2[index2];
                index2++;
            } else {
                result[index] = nums1[index1];
                index1++;
            }
            index++;
        }
        if (index1 < m) {
            for (int i = index1; i < m; i++) {
                result[index++] = nums1[i];
            }
        } else if (index2 < n) {
            for (int i = index2; i < n; i++) {
                result[index++] = nums2[i];
            }
        }
        System.arraycopy(result, 0, nums1, 0, result.length);
    }

    public static void main(String[] args) {
        Problem88 problem88 = new Problem88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0}, nums2 = new int[]{2, 5, 6};
        problem88.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1};
        nums2 = new int[]{};
        problem88.merge(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        problem88.merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
