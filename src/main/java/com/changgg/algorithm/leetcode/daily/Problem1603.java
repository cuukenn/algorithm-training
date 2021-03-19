package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem1603
 * @Description https://leetcode-cn.com/problems/design-parking-system/
 * @Date 2021/3/19 19:22
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1603 {
    private final int big;
    private final int medium;
    private final int small;
    private int cuBig;
    private int cuMedium;
    private int cuSmall;

    public Problem1603(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;

    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (this.cuBig < this.big) {
                    this.cuBig++;
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (this.cuMedium < this.medium) {
                    this.cuMedium++;
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (this.cuSmall < this.small) {
                    this.cuSmall++;
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        Problem1603 problem1603 = new Problem1603(1, 1, 0);
        System.out.println(problem1603.addCar(1));
        System.out.println(problem1603.addCar(2));
        System.out.println(problem1603.addCar(3));
        System.out.println(problem1603.addCar(1));
    }
}
