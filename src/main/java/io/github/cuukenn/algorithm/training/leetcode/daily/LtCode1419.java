package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/minimum-number-of-frogs-croaking/">leetcode1419</a>
 */
public class LtCode1419 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //1
        System.out.println(solution.minNumberOfFrogs("croakcroak"));
        //2
        System.out.println(solution.minNumberOfFrogs("crcoakroak"));
        //-1
        System.out.println(solution.minNumberOfFrogs("croakcrook"));
        //-1
        System.out.println(solution.minNumberOfFrogs("croakcroa"));
        //2
        System.out.println(solution.minNumberOfFrogs("crocakcroraoakk"));
    }

    static class Solution {
        private static final char MAX_CHAR = 's';
        private static final char[] STATUES = "croak".toCharArray();
        private static final char[] PRE_STATUS = new char[MAX_CHAR];

        static {
            char[] statuses = (new String(STATUES) + STATUES[0]).toCharArray();
            for (int i = 1; i < statuses.length; i++) {
                PRE_STATUS[statuses[i]] = statuses[i - 1];
            }
        }

        public int minNumberOfFrogs(String croakOfFrogs) {
            int[] cnt = new int[MAX_CHAR];
            for (char status : croakOfFrogs.toCharArray()) {
                char lastStatus = PRE_STATUS[status];
                if (cnt[lastStatus] > 0) {
                    cnt[lastStatus]--;
                } else if (status != STATUES[0]) {
                    return -1;
                }
                cnt[status]++;
            }
            for (int i = 0; i < STATUES.length - 1; i++) {
                if (cnt[STATUES[i]] > 0) {
                    return -1;
                }
            }
            return cnt[STATUES[STATUES.length - 1]];
        }
    }
}
