package com.changgg.algorithm.leetcode.daily;

/**
 * @Classname Problem1015
 * @Description https://leetcode-cn.com/problems/smallest-integer-divisible-by-k/
 * @Date 2021/3/14 00:04
 * @Created by changgg
 */
public class Problem1015 {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0)
            return -1;
        int i = 1;
        for (int n = 1; n % K != 0; i++) {
            n %= K;
            n = n * 10 + 1;
        }
        return i;
    }

    public static void main(String[] args) {
        Problem1015 problem1015 = new Problem1015();
        System.out.println(problem1015.smallestRepunitDivByK(1));
        System.out.println(problem1015.smallestRepunitDivByK(2));
        System.out.println(problem1015.smallestRepunitDivByK(3));
    }
}
