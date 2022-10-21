package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem191
 * @Description https://leetcode-cn.com/problems/number-of-1-bits/submissions/
 * @Date 2021/3/22 20:07
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem191 {
    public int hammingWeight(int n) {
        int rs = 0;
        for (int index = 0; index < 32; index++) {
            if ((n & (1 << index)) != 0) {
                rs++;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem191 problem191 = new Problem191();
        System.out.println(problem191.hammingWeight(00000000000000000000000000001011));
        System.out.println(problem191.hammingWeight(00000000000000000000000010000000));
    }
}
