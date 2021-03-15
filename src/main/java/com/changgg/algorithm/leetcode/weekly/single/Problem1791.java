package com.changgg.algorithm.leetcode.weekly.single;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changgg
 * @Classname Problem1791
 * @Description https://leetcode-cn.com/contest/weekly-contest-232/problems/find-center-of-star-graph/
 * @Date 2021/3/15 19:31
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1791 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (final int[] edge : edges) {
            map.merge(edge[0], 1, Integer::sum);
            map.merge(edge[1], 1, Integer::sum);
        }
        int rs = 0, max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            boolean isMax = entry.getValue() > max;
            if (isMax) {
                rs = entry.getKey();
                max = entry.getValue();
            }
            if (max == edges.length) {
                return rs;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem1791 problem1791 = new Problem1791();
        int[][] edges = new int[][]{{1, 2}, {2, 3}, {4, 2}};
        System.out.println(problem1791.findCenter(edges));
        edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(problem1791.findCenter(edges));
    }
}
