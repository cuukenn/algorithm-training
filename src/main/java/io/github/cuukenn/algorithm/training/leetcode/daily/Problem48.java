package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: see:https://leetcode-cn.com/problems/rotate-image/
 * @author: changgg
 * @create: 2021-02-24 19:46
 **/
public class Problem48 {
  public void rotate(int[][] matrix) {
    final int length = matrix.length;
    if (length <= 1) {
      return;
    }
    for (int x = 0; x < length - 1; x++) {
      for (int y = x; y < (length - x - 1); y++) {
        swap(matrix, x, y);
      }
    }
  }

  private void swap(int[][] matrix, int x, int y) {
    int localX = x, localY = y;
    int nextX = matrix.length - 1 - localY, nextY = localX;
    int lastValue = matrix[localY][localX];
    while (true) {
      //swap value
      int tm = matrix[nextY][nextX];
      matrix[nextY][nextX] = lastValue;
      lastValue = tm;
      //reset start
      localX = nextX;
      localY = nextY;
      //get next position
      nextX = matrix.length - 1 - localY;
      nextY = localX;
      if (nextX == x && nextY == y) {
        matrix[nextY][nextX] = lastValue;
        break;
      }
    }
  }

  public void print(int[][] matrix) {
    for (int[] num : matrix) {
      System.out.println(Arrays.toString(num) + "\n");
    }
  }

  public static void main(String[] args) {
    Problem48 problem48 = new Problem48();
//    int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//    problem48.rotate(matrix);
//    problem48.print(matrix);
//    matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//    problem48.rotate(matrix);
//    problem48.print(matrix);
    int[][] matrix = new int[][]{{1, 2}, {3, 4}};
    problem48.rotate(matrix);
    problem48.print(matrix);
  }
}
