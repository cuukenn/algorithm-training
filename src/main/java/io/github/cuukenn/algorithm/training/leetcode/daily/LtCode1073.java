package io.github.cuukenn.algorithm.training.leetcode.daily;

import io.github.cuukenn.algorithm.training.base.BinaryHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/adding-two-negabinary-numbers/">leetcode1073</a>
 */
public class LtCode1073 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1})));
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{0}, new int[]{0})));
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{0}, new int[]{1})));
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{0}, new int[]{1, 0})));
        System.out.println(Arrays.toString(solution.addNegabinary(new int[]{0}, new int[]{0})));
    }

    static class Solution1 {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            List<Integer> ans = new ArrayList<>();
            for (int c = 0, i = arr1.length - 1, j = arr2.length - 1; i >= 0 || j >= 0 || c != 0; i--, j--) {
                int a = i >= 0 ? arr1[i] : 0;
                int b = j >= 0 ? arr2[j] : 0;
                int x = a + b + c;
                c = 0;
                if (x >= 2) {
                    x -= 2;
                    c -= 1;
                } else if (x == -1) {
                    x = 1;
                    c += 1;
                }
                ans.add(x);
            }
            while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
                ans.remove(ans.size() - 1);
            }
            Collections.reverse(ans);
            return ans.stream().mapToInt(x -> x).toArray();
        }
    }

    static class Solution2 {
        public int[] addNegabinary(int[] arr1, int[] arr2) {
            return BinaryHelper.decimal2binary(BinaryHelper.binary2decimal(arr1, -2).add(BinaryHelper.binary2decimal(arr2, -2)), -2);
        }
    }
}
