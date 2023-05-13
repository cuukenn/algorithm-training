package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/number-of-valid-clock-times/">leetcode2437</a>
 */
public class LtCode2437 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //2
        System.out.println(solution.countTime("?5:00"));
        //100
        System.out.println(solution.countTime("0?:0?"));
        //1440
        System.out.println(solution.countTime("??:??"));

    }

    static class Solution {
        private static final char PLACEHOLDER = '?';

        public int countTime(String time) {
            char[] timeChars = time.toCharArray();
            return doCountTime(new char[]{timeChars[0], timeChars[1], timeChars[3], timeChars[4]}, 0);
        }

        private int doCountTime(char[] timeChar, int index) {
            if (index >= timeChar.length) {
                if (check(timeChar)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (timeChar[index] != PLACEHOLDER) {
                return doCountTime(timeChar, index + 1);
            }
            int count = 0;
            for (int i = 0; i <= 9; i++) {
                timeChar[index] = String.valueOf(i).toCharArray()[0];
                count += doCountTime(timeChar, index + 1);
                timeChar[index] = PLACEHOLDER;
            }
            return count;
        }

        private boolean check(char[] timeChar) {
            int hour = Integer.parseInt(timeChar[0] + String.valueOf(timeChar[1]));
            int minute = Integer.parseInt(timeChar[2] + String.valueOf(timeChar[3]));
            return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59;
        }
    }
}
