package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem87
 * @Description https://leetcode-cn.com/problems/scramble-string/
 * @Date 2021/4/16 21:29
 */
public class Problem87 {
    private String s1;
    private String s2;
    private int n;
    private int[][][] cache;
    private int N = -1, Y = 1, EMPTY = 0;

    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        this.n = s1.length();
        // cache 的默认值是 EMPTY
        this.cache = new int[n][n][n + 1];
        return isScrambleP(0, 0, n);
    }

    private boolean isScrambleP(int i, int j, int len) {
        if (cache[i][j][len] != EMPTY) return cache[i][j][len] == Y;
        String a = s1.substring(i, i + len), b = s2.substring(j, j + len);
        if (a.equals(b)) {
            cache[i][j][len] = Y;
            return true;
        }
        if (!check(a, b)) {
            cache[i][j][len] = N;
            return false;
        }
        for (int k = 1; k < len; k++) {
            // 对应了「s1 的 [0,i) & [i,n)」匹配「s2 的 [0,i) & [i,n)」
            if (isScrambleP(i, j, k) && isScrambleP(i + k, j + k, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
            // 对应了「s1 的 [0,i) & [i,n)」匹配「s2 的 [n-i,n) & [0,n-i)」
            if (isScrambleP(i, j + len - k, k) && isScrambleP(i + k, j, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
        }
        cache[i][j][len] = N;
        return false;
    }

    private boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] charsN1 = new int[26];
        int[] charsN2 = new int[26];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int index = 0; index < s1.length(); index++) {
            charsN1[chars1[index] - 'a']++;
            charsN2[chars2[index] - 'a']++;
        }
        for (int index = 0; index < 26; index++) {
            if (charsN1[index] != charsN2[index]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem87 problem87 = new Problem87();
        System.out.println(problem87.isScramble("great", "rgeat"));
        System.out.println(problem87.isScramble("abcde", "caebd"));
        System.out.println(problem87.isScramble("a", "a"));
    }
}
