package com.changgg.algorithm.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem5716
 * @Description https://leetcode-cn.com/contest/weekly-contest-234/problems/maximize-number-of-nice-divisors/
 * @Date 2021/3/28 11:07
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5716 {
    /**
     * X=3^n1
     * X=3^n1*2
     * X=3^n1*2*2
     *
     * @param primeFactors
     * @return
     */
    public int maxNiceDivisors(int primeFactors) {
        int mod = 1000000007;
        if (primeFactors <= 4) {
            return primeFactors;
        } else if (primeFactors % 3 == 0) {
            return (int) (quickPow(3, primeFactors / 3) % mod);
        } else if ((primeFactors) % 3 == 2) {
            return (int) (quickPow(3, (primeFactors - 2) / 3) * 2 % mod);
        } else {
            return (int) (quickPow(3, (primeFactors - 4) / 3) * 4 % mod);
        }
    }

    private long quickPow(long base, long time) {
        final int mod = 1000000007;
        long rs = 1L;
        while (time != 0) {
            if ((time & 1) == 1) {
                rs = rs * base % mod;
            }
            base = base * base % mod;
            time = time >> 1;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem5716 problem5716 = new Problem5716();
        System.out.println(problem5716.quickPow(3, 0));
        System.out.println(problem5716.quickPow(3, 1));
        System.out.println(problem5716.quickPow(3, 2));
        System.out.println(problem5716.quickPow(3, 3));
        System.out.println(problem5716.quickPow(3, 4));

        System.out.println(problem5716.maxNiceDivisors(5));
        System.out.println(problem5716.maxNiceDivisors(8));
        System.out.println(problem5716.maxNiceDivisors(73));
        System.out.println(problem5716.maxNiceDivisors(545918790));
    }
}
