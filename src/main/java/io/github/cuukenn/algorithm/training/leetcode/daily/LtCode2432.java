package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/the-employee-that-worked-on-the-longest-task/">leetcode2432</a>
 */
public class LtCode2432 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hardestWorker(10, new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}}));
        System.out.println(solution.hardestWorker(26, new int[][]{{1, 1}, {3, 7}, {2, 12}, {7, 17}}));
        System.out.println(solution.hardestWorker(2, new int[][]{{0, 10}, {1, 20}}));
    }

    static class Solution {
        public int hardestWorker(int n, int[][] logs) {
            int extId = logs[0][0];
            int maxTime = logs[0][1];
            for (int i = 1; i < logs.length; i++) {
                int curId = logs[i][0];
                int curTime = logs[i][1] - logs[i - 1][1];
                if (curTime > maxTime) {
                    maxTime = curTime;
                    extId = curId;
                } else if (curTime == maxTime) {
                    extId = Math.min(extId, curId);
                }
            }
            return extId;
        }
    }
}
