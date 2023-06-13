package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/number-of-unequal-triplets-in-array/">leetcode2475</a>
 */
public class LtCode2475 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        System.out.println(solution.unequalTriplets(new int[]{1, 1, 1, 1, 1}));
    }

    static class Solution {

        public int unequalTriplets(int[] nums) {
            return dfs(nums, 0, nums.length - 1, 3, new boolean[nums.length], new int[3]);
        }

        private int dfs(int[] nums, int start, int end, int cn, boolean[] selected, int[] selectedNums) {
            if (cn <= 0) {
                if (selectedNums[0] == selectedNums[1] || selectedNums[0] == selectedNums[2] || selectedNums[1] == selectedNums[2]) {
                    return 0;
                }
                return 1;
            }
            int rs = 0;
            for (int index = start; index <= end; index++) {
                if (selected[index]) {
                    continue;
                }
                selected[index] = true;
                selectedNums[cn - 1] = nums[index];
                rs += dfs(nums, index, end, cn - 1, selected, selectedNums);
                selected[index] = false;
                selectedNums[cn - 1] = 0;
            }
            return rs;
        }
    }
}
