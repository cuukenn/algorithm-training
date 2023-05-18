package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/determine-if-two-events-have-conflict/">leetcode2446</a>
 */
public class LtCode2446 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
        System.out.println(solution.haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
        System.out.println(solution.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
        System.out.println(solution.haveConflict(new String[]{"14:13", "22:08"}, new String[]{"02:40", "08:08"}));
    }

    static class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            return doHaveConflict(event1, event2) && doHaveConflict(event2, event1);
        }

        private boolean doHaveConflict(String[] event1, String[] event2) {
            String[] lastEventEndTime = event1[1].split(":");
            String[] currentEventEndTime = event2[0].split(":");
            int flag;
            if ((flag = lastEventEndTime[0].compareTo(currentEventEndTime[0])) > 0) {
                return true;
            } else if (flag == 0) {
                return lastEventEndTime[1].compareTo(currentEventEndTime[1]) >= 0;
            } else {
                return false;
            }
        }
    }
}
