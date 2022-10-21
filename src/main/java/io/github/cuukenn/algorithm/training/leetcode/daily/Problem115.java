package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem115
 * @Description https://leetcode-cn.com/problems/distinct-subsequences/
 * @Date 2021/3/17 21:23
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem115 {
    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) {
            return 0;
        }
        char[] sourceChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        int[][] rs = new int[s.length() + 1][t.length() + 1];
        for (int[] n : rs) {
            n[0] = 1;
        }
        for (int sIndex = 0; sIndex < sourceChars.length; sIndex++) {
            for (int tIndex = 0; tIndex < targetChars.length; tIndex++) {
                if (sourceChars[sIndex] == targetChars[tIndex]) {
                    rs[sIndex + 1][tIndex + 1] = rs[sIndex][tIndex] + rs[sIndex][tIndex + 1];
                } else {
                    rs[sIndex + 1][tIndex + 1] = rs[sIndex][tIndex + 1];
                }
            }
        }
        return rs[s.length()][t.length()];
    }

    public static void main(String[] args) {
        Problem115 problem115 = new Problem115();
        System.out.println(problem115.numDistinct("rabbbit", "rabbit"));
        System.out.println(problem115.numDistinct("babgbag", "bag"));
    }
}
