package io.github.cuukenn.algorithm.training.leetcode.daily;

import io.github.cuukenn.algorithm.training.base.BinaryHelper;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/convert-to-base-2/">leetcode1017</a>
 */
public class LtCode1017 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.baseNeg2(2));
        System.out.println(solution.baseNeg2(3));
        System.out.println(solution.baseNeg2(4));
    }

    static class Solution {
        public String baseNeg2(int n) {
            int[] binary = BinaryHelper.decimal2binary(BigInteger.valueOf(n), -2);
            return IntStream.of(binary).boxed().map(String::valueOf).collect(Collectors.joining(""));
        }
    }
}
