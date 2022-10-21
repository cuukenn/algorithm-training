package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem263
 * @Description https://leetcode-cn.com/problems/ugly-number/
 * @Date 2021/4/10 20:11
 */
public class Problem263 {
    public boolean isUgly(int n) {
        return isUglyP(n);
    }

    private boolean isUglyP(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (n % 2 == 0) {
            return isUglyP(n / 2);
        } else if (n % 3 == 0) {
            return isUglyP(n / 3);
        } else if (n % 5 == 0) {
            return isUglyP(n / 5);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Problem263 problem263 = new Problem263();
        System.out.println(problem263.isUgly(6));
        System.out.println(problem263.isUgly(8));
        System.out.println(problem263.isUgly(14));
    }
}
