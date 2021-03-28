package com.changgg.algorithm.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem5711
 * @Description https://leetcode-cn.com/contest/weekly-contest-233/problems/maximum-value-at-a-given-index-in-a-bounded-array/
 * @Date 2021/3/21 14:26
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5711 {
    //TODO 超时、未完成
    public int maxValue(int n, int index, int maxSum) {
        for (int currentMax = maxSum; currentMax >= 0; currentMax--) {
            final int sum = currentMax
                    + leftMin(currentMax, index)
                    + rightMin(currentMax, n - 1, index);
            if (sum <= maxSum) {
                return currentMax;
            }
        }
        return 0;
    }

    private int leftMin(int maxValue, int maxIndex) {
        if (maxValue - maxIndex > 1) {
            return ((maxValue - 1 + maxValue - maxIndex) * maxIndex) >> 1;
        } else {
            return (maxValue * (maxValue - 1) >> 1) + maxIndex - maxValue + 1;
        }
    }

    private int rightMin(int maxValue, int size, int currentIndex) {
        if (maxValue - size + currentIndex > 1) {
            return ((maxValue - 1 + maxValue - size + currentIndex) * (size - currentIndex)) >> 1;
        } else {
            return ((maxValue * (maxValue - 1)) >> 1) + size - currentIndex - maxValue + 1;
        }
    }

    public static void main(String[] args) {
        Problem5711 problem5711 = new Problem5711();
        System.out.println(problem5711.maxValue(4, 2, 6));
        System.out.println(problem5711.maxValue(6, 1, 10));
        System.out.println(problem5711.maxValue(3, 2, 18));
        System.out.println(problem5711.maxValue(4, 0, 4));
        System.out.println(problem5711.maxValue(9, 0, 90924720));
        System.out.println(problem5711.maxValue(8, 7, 14));
        System.out.println(problem5711.maxValue(4, 3, 4));
        System.out.println(problem5711.maxValue(3, 2, 18));
//        System.out.println(problem5711.rightMin(9, 10, 6));
//        System.out.println(problem5711.rightMin(18, 3, 2));
    }
}
