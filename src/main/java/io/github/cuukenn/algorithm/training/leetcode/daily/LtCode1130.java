package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/">leetcode1130</a>
 */
public class LtCode1130 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{6, 2, 4}));
        System.out.println(solution.mctFromLeafValues(new int[]{4, 11}));
    }

    static class Solution {
        private int sum;

        public int mctFromLeafValues(int[] arr) {
            sum = 0;
            dfs(arr, 0, arr.length - 1);
            return sum;
        }

        private int dfs(int[] arr, int sIndex, int eIndex) {
            if (eIndex < sIndex) {
                return -1;
            }
            int max = -1, mIndex = -1;
            for (int index = sIndex; index <= eIndex; index++) {
                if (arr[index] >= max) {
                    max = arr[index];
                    mIndex = index;
                }
            }
            int left = dfs(arr, sIndex, mIndex - 1);
            int right = dfs(arr, mIndex + 1, eIndex);
            if (left != -1) {
                sum += left * max;
            }
            if (right != -1) {
                sum += right * max;
            }
            return max;
        }
    }
}
