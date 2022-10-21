package io.github.cuukenn.algorithm.training.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem1790
 * @Description https://leetcode-cn.com/contest/weekly-contest-232/problems/check-if-one-string-swap-can-make-strings-equal/
 * @Date 2021/3/15 19:17
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] chars = s1.toCharArray();
        for (int x = 0; x < s1.length(); x++) {
            for (int y = x; y < s1.length(); y++) {
                swap(chars, x, y);
                if (String.valueOf(chars).equals(s2)) {
                    return true;
                }
                swap(chars, x, y);
            }
        }
        return false;
    }

    private void swap(char[] chars, int index1, int index2) {
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }

    public static void main(String[] args) {
        Problem1790 problem1790 = new Problem1790();
        System.out.println(problem1790.areAlmostEqual("bank", "kanb"));
        System.out.println(problem1790.areAlmostEqual("attack", "defend"));
        System.out.println(problem1790.areAlmostEqual("kelb", "kelb"));
        System.out.println(problem1790.areAlmostEqual("abcd", "dcba"));
    }
}
