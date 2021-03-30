package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem74
 * @Description https://leetcode-cn.com/problems/search-a-2d-matrix/submissions/
 * @Date 2021/3/30 19:05
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int h = matrix.length, w = matrix[0].length, size = h * w;
        int start = 0, end = size - 1;
        while (start + 1 < end) {
            int mid = start + ((end - start) >> 1);
            int y = mid / w;
            int x = mid - y * w;
            int tmp = matrix[y][x];
            if (tmp == target) {
                return true;
            }
            if (tmp > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int y1 = start / w;
        int x1 = start - y1 * w;
        int y2 = end / w;
        int x2 = end - y2 * w;
        return matrix[y1][x1] == target || matrix[y2][x2] == target;
    }

    public static void main(String[] args) {
        Problem74 problem74 = new Problem74();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
//        System.out.println(problem74.searchMatrix(matrix, 1));
//        System.out.println(problem74.searchMatrix(matrix, 3));
//        System.out.println(problem74.searchMatrix(matrix, 13));
        System.out.println(problem74.searchMatrix(matrix, 60));
//        System.out.println(problem74.searchMatrix(matrix, -60));
    }
}
