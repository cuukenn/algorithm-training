package com.changgg.algorithm.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changgg
 * @Classname Problem1441
 * @Description https://leetcode-cn.com/problems/build-an-array-with-stack-operations/submissions/
 * @Date 2021/3/26 19:50
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1441 {
    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        List<String> rs = new ArrayList<>();
        for (int i = 1; i <= n && index < target.length; i++) {
            if (target[index] == i) {
                rs.add("Push");
                index++;
            } else {
                rs.add("Push");
                rs.add("Pop");
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem1441 problem1441 = new Problem1441();
        int[] target = new int[]{1, 3};
        System.out.println(problem1441.buildArray(target, 3));
        target = new int[]{1, 2, 3};
        System.out.println(problem1441.buildArray(target, 3));
        target = new int[]{1, 2};
        System.out.println(problem1441.buildArray(target, 4));
        target = new int[]{2, 3, 4};
        System.out.println(problem1441.buildArray(target, 4));
    }
}
