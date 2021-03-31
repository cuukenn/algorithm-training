package com.changgg.algorithm.leetcode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author changgg
 * @Classname Problem90
 * @Description https://leetcode-cn.com/problems/subsets-ii/solution/
 * @Date 2021/3/31 18:50
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rs = new ArrayList<>();
        rs.add(new ArrayList<>());
        for (int num : nums) {
            final List<List<Integer>> tmp = new ArrayList<>(rs);
            for (List<Integer> list : rs) {
                ArrayList<Integer> integers = new ArrayList<>(list);
                integers.add(num);
                tmp.add(integers);
            }
            rs = tmp;
        }
        List<List<Integer>> newRs = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (List<Integer> tmp : rs) {
            String s = tmp.toString();
            if (!set.contains(s)) {
                newRs.add(tmp);
                set.add(s);
            }
        }
        return newRs;
    }

    private void print(List<List<Integer>> list) {
        for (List<Integer> li : list) {
            System.out.print(li);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem90 problem90 = new Problem90();
        int[] nums = new int[]{1, 2, 2};
        problem90.print(problem90.subsetsWithDup(nums));
        nums = new int[]{0};
        problem90.print(problem90.subsetsWithDup(nums));
        nums = new int[]{};
        problem90.print(problem90.subsetsWithDup(nums));
    }
}
