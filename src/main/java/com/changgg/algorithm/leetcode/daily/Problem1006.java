package com.changgg.algorithm.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changgg
 * @Classname Problem1006
 * @Description https://leetcode-cn.com/problems/clumsy-factorial/submissions/
 * @Date 2021/4/1 19:04
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1006 {
    public int clumsy(int N) {
        final char[] opts = new char[]{'*', '/', '+', '-'};
        int currentOpt = 0, optSize = opts.length;
        int tmp = N;
        List<Integer> nums = new ArrayList<>();
        for (int n = N - 1; n >= 1; n--) {
            char opt = opts[currentOpt % optSize];
            if (opt == '+' || opt == '-') {
                nums.add(tmp);
                tmp = n;
            } else if (opt == '*') {
                tmp = tmp * n;
            } else {
                tmp = tmp / n;
            }
            currentOpt++;
        }
        nums.add(tmp);
        int rs = nums.get(0);
        boolean flag = true;
        for (int index = 1; index < nums.size(); index++) {
            int n = nums.get(index);
            if (flag) {
                rs += n;
                flag = false;
            } else {
                rs -= n;
                flag = true;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem1006 problem1006 = new Problem1006();
        System.out.println(problem1006.clumsy(4));
        System.out.println(problem1006.clumsy(10));
        System.out.println(problem1006.clumsy(1));
    }
}
