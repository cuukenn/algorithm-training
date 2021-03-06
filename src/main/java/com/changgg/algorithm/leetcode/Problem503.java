package com.changgg.algorithm.leetcode;

import java.util.Arrays;

/**
 * see:https://leetcode-cn.com/problems/next-greater-element-ii/
 *
 * @author changgg
 */
public class Problem503 {
    public int[] nextGreaterElements(int[] nums) {
        final int[] rs = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            int tmp = -1;
            int add = 1;
            while (true) {
                int nextIndex = (index + add) % nums.length;
                if (nextIndex == index) {
                    break;
                }
                if (nums[nextIndex] > nums[index]) {
                    tmp = nums[nextIndex];
                    break;
                }
                add++;
            }
            rs[index] = tmp;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem503 problem503 = new Problem503();
        System.out.println(Arrays.toString(problem503.nextGreaterElements(new int[]{1, 2, 1})));
    }
}
