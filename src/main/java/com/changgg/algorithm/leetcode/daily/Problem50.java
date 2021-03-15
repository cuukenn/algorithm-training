package com.changgg.algorithm.leetcode.daily;

/**
 * @program: algorithm
 * @description: see:https://leetcode-cn.com/problems/powx-n/comments/
 * @author: changgg
 * @create: 2021-02-26 20:08
 **/
public class Problem50 {
  public double myPow(double x, int n) {
    double res = 1.0;
    for (int i = n; i != 0; i /= 2) {
      if (i % 2 != 0) {
        res *= x;
      }
      x *= x;
    }
    return n < 0 ? 1 / res : res;
  }

  public static void main(String[] args) {
    Problem50 problem40 = new Problem50();
    System.out.println(problem40.myPow(2, 10));
    System.out.println(problem40.myPow(2, -2));
    System.out.println(problem40.myPow(0, 10));
    System.out.println(problem40.myPow(0.44528, 0));
    System.out.println(problem40.myPow(2.00000, -2147483648));
  }
}
