package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/">leetcode2517</a>
 */
public class LtCode2460 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(solution.applyOperations(new int[]{0, 1})));
    }

    static class Solution {
        public int[] applyOperations(int[] nums) {
            for (int index = 0; index < nums.length - 1; index++) {
                if (nums[index] == nums[index + 1]) {
                    nums[index] <<= 1;
                    nums[index + 1] = 0;
                }
            }
            int[] newNums = new int[nums.length];
            for (int index = 0, lastIndex = 0; index < nums.length; index++) {
                if (nums[index] == 0) {
                    continue;
                }
                newNums[lastIndex++] = nums[index];
            }
            return newNums;
        }
    }
}
