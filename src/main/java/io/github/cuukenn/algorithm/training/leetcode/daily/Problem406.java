package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;

/**
 * @author changgg
 * @Classname Problem406
 * @Description https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * @Date 2021/3/19 19:23
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        final int[][] rs = new int[people.length][];
        for (int[] p : people) {
            int space = p[1];
            for (int index = 0; index < rs.length; index++) {
                if (rs[index] != null) {
                    continue;
                }
                if (space <= 0) {
                    rs[index] = p;
                    break;
                } else {
                    space--;
                }
            }
        }
        return rs;
    }

    public void print(int[][] people) {
        for (int[] p : people) {
            System.out.print(Arrays.toString(p) + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem406 problem406 = new Problem406();
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        problem406.print(problem406.reconstructQueue(people));
        people = new int[][]{{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        problem406.print(problem406.reconstructQueue(people));
    }
}
