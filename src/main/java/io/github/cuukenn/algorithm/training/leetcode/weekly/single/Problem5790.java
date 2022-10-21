package io.github.cuukenn.algorithm.training.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem5790
 * @Description https://leetcode-cn.com/contest/weekly-contest-233/problems/maximum-ascending-subarray-sum/
 * @Date 2021/3/21 10:30
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5790 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int rs = nums[0], tmp = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > nums[index - 1]) {
                tmp += nums[index];
            } else {
                rs = Math.max(rs, tmp);
                tmp = nums[index];
            }
        }
        return Math.max(rs, tmp);
    }

    public static void main(String[] args) {
        Problem5790 problem5790 = new Problem5790();
        int[] nums = new int[]{10, 20, 30, 5, 10, 50};
        System.out.println(problem5790.maxAscendingSum(nums));
        nums = new int[]{10, 20, 30, 40, 50};
        System.out.println(problem5790.maxAscendingSum(nums));
        nums = new int[]{12, 17, 15, 13, 10, 11, 12};
        System.out.println(problem5790.maxAscendingSum(nums));
        nums = new int[]{100, 10, 1};
        System.out.println(problem5790.maxAscendingSum(nums));
        nums = new int[]{100};
        System.out.println(problem5790.maxAscendingSum(nums));
        nums = new int[]{};
        System.out.println(problem5790.maxAscendingSum(nums));
    }
}
