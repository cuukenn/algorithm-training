package com.changgg.algorithm.leetcode.daily;

import java.util.Arrays;

/**
 * @author changgg
 * @Classname Problem59
 * @Description https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @Date 2021/3/16 18:53
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem59 {
    public int[][] generateMatrix(int n) {
        final int[][] matrix = new int[n][n];
        int startX = 0, startY = 0, endX = n - 1, endY = n - 1, index = 1, plus = n - 1;
        while (startX <= endX && startY <= endY) {
            if (startY == endY) {
                generateMatrix(matrix, startX, startY, endX - 1, startY, 1, 0, index);
                index += plus;
                if (startX != endX) {
                    generateMatrix(matrix, endX, startY, endX, endY - 1, 0, 1, index);
                    index += plus;
                }
            } else if (startX == endX) {
                generateMatrix(matrix, endX, startY, endX, endY - 1, 0, 1, index);
                index += plus;
                generateMatrix(matrix, endX, endY, startX + 1, endY, -1, 0, index);
                index += plus;
            } else {
                generateMatrix(matrix, startX, startY, endX - 1, startY, 1, 0, index);
                index += plus;
                generateMatrix(matrix, endX, startY, endX, endY - 1, 0, 1, index);
                index += plus;
                generateMatrix(matrix, endX, endY, startX + 1, endY, -1, 0, index);
                index += plus;
                generateMatrix(matrix, startX, endY, startX, startY + 1, 0, -1, index);
                index += plus;
            }
            startX++;
            startY++;
            endX--;
            endY--;
            plus -= 2;
        }
        return matrix;
    }

    private void generateMatrix(int[][] matrix,
                                int startX, int startY,
                                int endX, int endY,
                                int plusX, int plusY,
                                int index) {
        final int localStartX = Math.min(startX, endX);
        final int localStartY = Math.min(startY, endY);
        final int localEndX = Math.max(startX, endX);
        final int localEndY = Math.max(startY, endY);
        while (true) {
            if (startX > localEndX || startX < localStartX) {
                break;
            }
            if (startY > localEndY || startY < localStartY) {
                break;
            }
            matrix[startY][startX] = index++;
            startX += plusX;
            startY += plusY;
        }
    }


    public void print(int[][] nums) {
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    public static void main(String[] args) {
        Problem59 problem59 = new Problem59();
        problem59.print(problem59.generateMatrix(3));
        problem59.print(problem59.generateMatrix(1));
    }
}
