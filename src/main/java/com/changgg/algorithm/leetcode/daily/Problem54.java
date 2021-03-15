package com.changgg.algorithm.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: see:https://leetcode-cn.com/problems/spiral-matrix/
 * @author: changgg
 * @create: 2021-02-26 20:55
 **/
public class Problem54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    int startX = 0, endX = matrix[0].length - 1, startY = 0, endY = matrix.length - 1;
    List<Integer> result = new ArrayList<>();
    while (startX <= endX && startY <= endY) {
      if (startY == endY) {
        result.addAll(spiralOrder(matrix, startX, startY, endX - 1, startY, 1, 0));
        if (startX != endX) {
          result.addAll(spiralOrder(matrix, endX, startY, endX, endY - 1, 0, 1));
        }
      } else if (startX == endX) {
        result.addAll(spiralOrder(matrix, endX, startY, endX, endY - 1, 0, 1));
        result.addAll(spiralOrder(matrix, endX, endY, startX + 1, endY, -1, 0));
      } else {
        result.addAll(spiralOrder(matrix, startX, startY, endX - 1, startY, 1, 0));
        result.addAll(spiralOrder(matrix, endX, startY, endX, endY - 1, 0, 1));
        result.addAll(spiralOrder(matrix, endX, endY, startX + 1, endY, -1, 0));
        result.addAll(spiralOrder(matrix, startX, endY, startX, startY + 1, 0, -1));
      }
      startX++;
      startY++;
      endX--;
      endY--;
    }
    return result;
  }

  private List<Integer> spiralOrder(int[][] matrix, int startX, int startY, int endX, int endY, int moveX, int moveY) {
    List<Integer> result = new ArrayList<>();
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
      result.add(matrix[startY][startX]);
      startX += moveX;
      startY += moveY;
    }
    return result;
  }

  public static void main(String[] args) {
    Problem54 problem54 = new Problem54();
    System.out.println(problem54.spiralOrder(new int[][]{{3}, {2}}));
    System.out.println(problem54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    System.out.println(problem54.spiralOrder(new int[][]{{1, 2}, {4, 3}}));
    System.out.println(problem54.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
  }
}
