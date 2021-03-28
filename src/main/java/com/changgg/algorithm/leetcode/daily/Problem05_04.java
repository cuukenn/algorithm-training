package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem05_04
 * @Description https://leetcode-cn.com/problems/closed-number-lcci/
 * @Date 2021/3/27 22:00
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem05_04 {
    //TODO 未完成
    private int findMax(int num) {
        int tmp = num;
        int leftZeroIndex = -1, index = 0, rightOneSize = 0;
        while (tmp > 0) {
            if (index != 0 && (tmp & 1) == 0 && ((num >> (index - 1)) & 1) == 1) {
                leftZeroIndex = index;
                break;
            }
            if ((tmp & 1) == 1) {
                rightOneSize++;
            }
            tmp = tmp >> 1;
            index++;
        }
        if (leftZeroIndex < 0) {
            return num << 1;
        }
        //0 1对调
        num = num | (1 << leftZeroIndex);
        num = num & ((~0) ^ (1 << (leftZeroIndex - 1)));
        //1往后挪
        leftZeroIndex = leftZeroIndex - 2;
        rightOneSize--;
        for (index = 0; index <= leftZeroIndex; index++) {
            if (rightOneSize > 0) {
                num = num | (1 << index);
                rightOneSize--;
            } else {
                if ((num & (1 << index)) == 1) {
                    num = num & ((~0) ^ (1 << (index - 1)));
                }
            }
        }
        return num > 0 ? num : -1;
    }

    public static void main(String[] args) {
        Problem05_04 problem05_04 = new Problem05_04();
        System.out.println(problem05_04.findMax(1));
        System.out.println(problem05_04.findMax(2));
        System.out.println(problem05_04.findMax(124));
        System.out.println(problem05_04.findMax(201314));
    }
}
