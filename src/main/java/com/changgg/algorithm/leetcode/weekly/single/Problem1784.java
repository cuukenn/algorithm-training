package com.changgg.algorithm.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem1784
 * @Description https://leetcode-cn.com/contest/weekly-contest-231/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 * @Date 2021/3/16 20:54
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1784 {
    public boolean checkOnesSegment(String s) {
        return s.split("0+").length == 1;
    }

    public static void main(String[] args) {
        Problem1784 problem1784 = new Problem1784();
        System.out.println(problem1784.checkOnesSegment("1001"));
        System.out.println(problem1784.checkOnesSegment("110"));
    }
}
