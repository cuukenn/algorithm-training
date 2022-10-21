package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem190
 * @Description https://leetcode-cn.com/problems/reverse-bits/submissions/
 * @Date 2021/3/29 19:16
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem190 {
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int rs = 1;
        int index = 0;
        while (n != 0) {
            if (index == 31) {
                break;
            }
            if ((n & 1) == 1) {
                rs = (rs << 1) | 1;
            } else {
                rs = rs << 1;
            }
            n = n >> 1;
            index++;
        }
        return rs << (31 - index + 1) | (n >= 0 ? 0 : 1);
    }

    public static void main(String[] args) {
        Problem190 problem190 = new Problem190();
        System.out.println(problem190.reverseBits(0b00000010100101000001111010011100));
        System.out.println(problem190.reverseBits(0b11111111111111111111111111111101));
        System.out.println(problem190.reverseBits(0));
    }
}
