package com.changgg.algorithm.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem1422
 * @Description https://leetcode-cn.com/problems/maximum-score-after-splitting-a-string/submissions/
 * @Date 2021/3/30 22:38
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1422 {
    public int maxScore(String s) {
        int leftZero = 0, rightOne = 0, index = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (index == 0) {
                if (c == '0') {
                    leftZero++;
                }
            } else {
                if (c == '1') {
                    rightOne++;
                }
            }
            index++;
        }
        int score = leftZero + rightOne;
        for (index = 1; index < chars.length - 1; index++) {
            if (chars[index] == '0') {
                leftZero++;
            } else {
                rightOne--;
            }
            score = Math.max(score, leftZero + rightOne);
        }
        return score;
    }

    public static void main(String[] args) {
        Problem1422 problem1422 = new Problem1422();
        System.out.println(problem1422.maxScore("011101"));
        System.out.println(problem1422.maxScore("00111"));
        System.out.println(problem1422.maxScore("1111"));
        System.out.println(problem1422.maxScore("00111"));
        System.out.println(problem1422.maxScore("00"));
    }
}
