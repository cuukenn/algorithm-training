package com.changgg.algorithm.leetcode.daily;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author changgg
 * @Classname Problem179
 * @Description https://leetcode-cn.com/problems/largest-number/submissions/
 * @Date 2021/4/1 20:58
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem179 {
    public String largestNumber(int[] nums) {
        String[] numString = new String[nums.length];
        int index = 0;
        for (int num : nums) {
            numString[index] = num + "";
            index++;
        }
        Arrays.sort(numString, (firt, last) -> (new BigInteger(firt + last).compareTo(new BigInteger(last + firt))));
        StringBuilder rs = new StringBuilder();
        for (String s : numString) {
            rs.insert(0, s);
        }
        return new BigInteger(rs.toString()).toString();
    }

    public static void main(String[] args) {
        Problem179 problem179 = new Problem179();
        int[] nums = new int[]{10, 2};
        System.out.println(problem179.largestNumber(nums));
        nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(problem179.largestNumber(nums));
        nums = new int[]{1};
        System.out.println(problem179.largestNumber(nums));
        nums = new int[]{10};
        System.out.println(problem179.largestNumber(nums));
    }
}
