package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem1143
 * @Description https://leetcode-cn.com/problems/longest-common-subsequence/submissions/
 * @Date 2021/4/3 18:27
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        final int[][] cache = new int[text2.length() + 1][text1.length() + 1];
        final char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
        for (int y = 1; y <= text2.length(); y++) {
            for (int x = 1; x <= text1.length(); x++) {
                cache[y][x] = Math.max(cache[y - 1][x], cache[y][x - 1]);
                if (chars1[x - 1] == chars2[y - 1]) {
                    cache[y][x] = cache[y - 1][x - 1] + 1;
                } else {
                    cache[y][x] = Math.max(cache[y - 1][x], cache[y][x - 1]);
                }
            }
        }
        return cache[text2.length()][text1.length()];
    }

    public static void main(String[] args) {
        Problem1143 problem1143 = new Problem1143();
        System.out.println(problem1143.longestCommonSubsequence("ezupkr", "ubmrapg"));
        System.out.println(problem1143.longestCommonSubsequence("abcde", "ace"));
        System.out.println(problem1143.longestCommonSubsequence("abc", "abc"));
        System.out.println(problem1143.longestCommonSubsequence("abc", "def"));
        System.out.println(problem1143.longestCommonSubsequence("ylqpejqbalahwr", "yrkzavgdmdgtqpg"));
        System.out.println(problem1143.longestCommonSubsequence("yzebsbuxmtcfmtodclszgh",
                "ejevmhcvshclydqrulwbyha"));
        System.out.println(problem1143.longestCommonSubsequence("fmtclsfaxchgjavqrifqbkzspazw",
                "nczivetoxqjclwbwtibqvelwxsdaz"));
        System.out.println(problem1143.longestCommonSubsequence("bsbininm",
                "jmjkbkjkv"));
        System.out.println(problem1143.longestCommonSubsequence("bsbininm",
                "jmjkbkjkv"));
    }
}
