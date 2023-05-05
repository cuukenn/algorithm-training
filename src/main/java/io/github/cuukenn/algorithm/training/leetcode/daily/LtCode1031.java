package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/maximum-sum-of-two-non-overlapping-subarrays/">leetcode1031</a>
 */
public class LtCode1031 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
        System.out.println(solution.maxSumTwoNoOverlap(new int[]{3, 8, 1, 3, 2, 1, 8, 9, 0}, 3, 2));
        System.out.println(solution.maxSumTwoNoOverlap(new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8}, 4, 3));
    }

    static class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            return Math.max(doMaxSumTwoNoOverlap(nums, firstLen, secondLen), doMaxSumTwoNoOverlap(nums, secondLen, firstLen));
        }

        private int doMaxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int sumLeft = 0;
            for (int i = 0; i < firstLen; i++) {
                sumLeft += nums[i];
            }
            int sumLeftMax = sumLeft;
            int sumRight = 0;
            for (int i = firstLen; i < firstLen + secondLen; i++) {
                sumRight += nums[i];
            }
            int rs = sumLeftMax + sumRight;
            for (int i = firstLen, j = firstLen + secondLen; j < nums.length; i++, j++) {
                sumLeft += nums[i] - nums[i - firstLen];
                sumLeftMax = Math.max(sumLeft, sumLeftMax);
                sumRight += nums[j] - nums[j - secondLen];
                rs = Math.max(rs, sumLeftMax + sumRight);
            }
            return rs;
        }
    }
}
