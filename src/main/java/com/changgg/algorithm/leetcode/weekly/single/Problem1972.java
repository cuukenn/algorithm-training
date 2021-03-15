package com.changgg.algorithm.leetcode.weekly.single;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author changgg
 * @Classname Problem1972
 * @Description https://leetcode-cn.com/contest/weekly-contest-232/problems/maximum-average-pass-ratio/
 * @Date 2021/3/15 19:44
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1972 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        final Queue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> {
            double avg1 = o1[0] * 1.0 / o1[1];
            double avg2 = o2[0] * 1.0 / o2[1];

            double avg1_add = (o1[0] + 1) * 1.0 / (o1[1] + 1);
            double avg2_add = (o2[0] + 1) * 1.0 / (o2[1] + 1);

            double tmp1_add = avg1_add - avg1;
            double tmp2_add = avg2_add - avg2;
            if (tmp1_add == tmp2_add) {
                return 0;
            }
            return tmp1_add - tmp2_add > 0 ? -1 : 1;
        });
        for (int[] one : classes) {
            queue.add(new Integer[]{one[0], one[1]});
        }
        while (extraStudents > 0) {
            Integer[] poll = queue.poll();
            if (poll != null) {
                queue.add(new Integer[]{poll[0] + 1, poll[1] + 1});
                extraStudents--;
            }
        }
        double rs = 0.0;
        while (!queue.isEmpty()) {
            Integer[] poll = queue.poll();
            rs += poll[0] * 1.0 / poll[1];
        }
        return rs / classes.length;
    }


    public static void main(String[] args) {
        Problem1972 problem1792 = new Problem1972();
        int[][] classes = new int[][]{{1, 2}, {3, 5}, {2, 2}};
        System.out.println(problem1792.maxAverageRatio(classes, 2));
        classes = new int[][]{{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        System.out.println(problem1792.maxAverageRatio(classes, 4));
    }
}
