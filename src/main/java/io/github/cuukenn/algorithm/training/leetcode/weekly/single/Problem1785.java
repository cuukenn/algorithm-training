package io.github.cuukenn.algorithm.training.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem1785
 * @Description https://leetcode-cn.com/contest/weekly-contest-231/problems/minimum-elements-to-add-to-form-a-given-sum/
 * @Date 2021/3/16 21:10
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1785 {
    public int minElements(int[] nums, int limit, int goal) {
        //关键点：溢出
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        return (int) ((Math.abs(sum - goal) + limit - 1) / limit);
    }

    public static void main(String[] args) {
        Problem1785 problem1785 = new Problem1785();
        int[] nums = new int[]{1, -1, 1};
        System.out.println(problem1785.minElements(nums, 3, 4));
        nums = new int[]{1, -10, 9, 1};
        System.out.println(problem1785.minElements(nums, 100, 0));
    }
}
