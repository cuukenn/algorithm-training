package com.changgg.algorithm.leetcode;

/**
 * @author changgg
 * @Classname Problem367
 * @Description https://leetcode-cn.com/problems/valid-perfect-square/submissions/
 * @date 2021/3/14 20:07
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem367 {
    public boolean isPerfectSquare(int num) {
        int minBound = 0, maxBound = getMaxBound(num);
        while (true) {
            int mid = minBound + ((maxBound - minBound) >> 1);
            int tmp = mid * mid;
            if (tmp == num) {
                return true;
            }
            if (tmp > num) {
                maxBound = mid - 1;
            } else {
                minBound = mid + 1;
            }
            if (minBound == maxBound) {
                return minBound * minBound == num;
            }
        }
    }

    private int getMaxBound(int num) {
        int size = ((num + "").length() - 2) >> 1;
        int minus = 1;
        while (size > 0) {
            minus = minus * 10;
            size--;
        }
        int index = 0;
        while (index * minus * index * minus < num && (index + 1) * minus * (index + 1) * minus >= 0) {
            index++;
        }
        if (index * minus >= num) {
            return index * minus;
        } else {
            int min = index * minus, max = (index + 1) * minus;
            while (true) {
                int mid = min + ((max - min) >> 1);
                int tmp = mid * mid;
                if (tmp < 0 || tmp > num) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
                if (min >= max) {
                    return max;
                }
            }
        }
    }

    public static void main(String[] args) {
        Problem367 problem367 = new Problem367();
        System.out.println(problem367.isPerfectSquare(1));
        System.out.println(problem367.isPerfectSquare(16));
        System.out.println(problem367.isPerfectSquare(14));
        System.out.println(problem367.isPerfectSquare(318096));
        System.out.println(problem367.isPerfectSquare(2000105819));
        System.out.println(problem367.isPerfectSquare(2147483647));
        System.out.println(problem367.isPerfectSquare(2147395600));
    }
}
