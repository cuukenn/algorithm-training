package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/">leetcode1016</a>
 */
public class LtCode1016 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //true
        System.out.println(solution.queryString("0110", 3));
        //false
        System.out.println(solution.queryString("0110", 4));
        //false
        System.out.println(solution.queryString("110101011011000011011111000000", 15));
        //true
        System.out.println(solution.queryString("1111000101", 5));
    }

    static class Solution {

        public boolean queryString1(String s, int n) {
            StringBuilder stringBuilder = new StringBuilder();
            final int binaryBound = 2;
            for (int i = 1; i <= n; i++) {
                int cur = i;
                while (cur >= binaryBound) {
                    stringBuilder.append(cur % binaryBound);
                    cur = cur / binaryBound;
                }
                stringBuilder.append(cur);
                String nBinary = stringBuilder.reverse().toString();
                stringBuilder.delete(0, stringBuilder.length());
                if (!s.contains(nBinary)) {
                    return false;
                }
            }
            return true;
        }

        public boolean queryString(String s, int n) {
            if (n == 1) {
                return s.contains("1");
            }
            int k = Integer.toBinaryString(n).length() - 1;
            return doQueryString(s, k, n / 2 + 1, (1 << k) - 1) && doQueryString(s, k + 1, 1 << k, n);
        }

        private boolean doQueryString(String s, int wind, int lower, int upper) {
            if (lower > upper) {
                return true;
            }
            Set<Integer> numSet = new HashSet<>();
            int rangeNum = Integer.parseInt(s.substring(0, wind - 1), 2);
            int mask = (1 << (wind - 1)) - 1;
            for (int index = wind - 1; index < s.length(); index++) {
                rangeNum = ((rangeNum & mask) << 1) | s.charAt(index) - '0';
                if (rangeNum >= lower && rangeNum <= upper) {
                    numSet.add(rangeNum);
                }
            }
            return numSet.size() == upper - lower + 1;
        }
    }
}
