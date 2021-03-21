package com.changgg.algorithm.leetcode.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author changgg
 * @Classname Problem73
 * @Description https://leetcode-cn.com/problems/set-matrix-zeroes/submissions/
 * @Date 2021/3/21 20:23
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem73 {
    public void setZeroes(int[][] matrix) {
        final Set<Integer> cols = new HashSet<>();
        final Set<Integer> rows = new HashSet<>();
        for (int x = 0; x < matrix[0].length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                if (matrix[y][x] == 0) {
                    rows.add(x);
                    cols.add(y);
                }
            }
        }
        for (int y : cols) {
            matrix[y] = new int[matrix[y].length];
        }
        for (int x : rows) {
            for (int y = 0; y < matrix.length; y++) {
                matrix[y][x] = 0;
            }
        }
    }

    private void print(int[][] matrix) {
        for (int[] ma : matrix) {
            System.out.println(Arrays.toString(ma));
        }
    }

    public static void main(String[] args) {
        Problem73 problem73 = new Problem73();
        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        problem73.setZeroes(matrix);
        problem73.print(matrix);

        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        problem73.setZeroes(matrix);
        problem73.print(matrix);
    }
}
