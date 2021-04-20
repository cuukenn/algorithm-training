package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem28
 * @Description https://leetcode-cn.com/problems/implement-strstr/
 * @Date 2021/4/20 22:33
 */
public class Problem28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() <= 0) {
            return 0;
        }
        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();
        for (int index = 0; index < haystack.length(); index++) {
            int i = index, j = 0;
            while (i < haystack.length() && j < c2.length && c1[i] == c2[j]) {
                i++;
                j++;
            }
            if (j >= c2.length) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem28 problem28 = new Problem28();
        System.out.println(problem28.strStr("hello", "ll"));
        System.out.println(problem28.strStr("aaaaa", "bba"));
    }
}
