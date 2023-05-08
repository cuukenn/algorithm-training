package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/">leetcode1263</a>
 */
public class LtCode1263 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPushBox(
            new char[][]{
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'T', '#', '#', '#', '#'},
                {'#', '.', '.', 'B', '.', '#'},
                {'#', '.', '#', '#', '.', '#'},
                {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}
            }
        ));
        System.out.println(solution.minPushBox(
            new char[][]{
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'T', '#', '#', '#', '#'},
                {'#', '.', '.', 'B', '.', '#'},
                {'#', '#', '#', '#', '.', '#'},
                {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}
            }
        ));
        System.out.println(solution.minPushBox(
            new char[][]{
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'T', '.', '.', '#', '#'},
                {'#', '.', '#', 'B', '.', '#'},
                {'#', '.', '.', '.', '.', '#'},
                {'#', '.', '.', '.', 'S', '#'},
                {'#', '#', '#', '#', '#', '#'}
            }
        ));
        System.out.println(solution.minPushBox(
            new char[][]{
                {'#', '.', '.', '#', 'T', '#', '#', '#', '#'},
                {'#', '.', '.', '#', '.', '#', '.', '.', '#'},
                {'#', '.', '.', '#', '.', '#', 'B', '.', '#'},
                {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '.', '.', '.', '#', '.', 'S', '#'},
                {'#', '.', '.', '#', '.', '#', '#', '#', '#'}
            }
        ));
    }

    static class Solution {
        private static final char PLAYER = 'S';
        private static final char WALL = '#';
        private static final char BOX = 'B';
        private static final char TARGET = 'T';

        public int minPushBox(char[][] grid) {
            int[] initialPosition = findPlayerAndBox(grid);
            Queue<Integer[]> stepQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            stepQueue.add(new Integer[]{0, initialPosition[0], initialPosition[1], initialPosition[2], initialPosition[3]});
            Set<String> visited = new HashSet<>();
            Integer[] currentPosition;
            int[][] nextSteps = new int[][]{
                {1, 0},
                {0, -1},
                {-1, 0},
                {0, 1},
            };
            while ((currentPosition = stepQueue.poll()) != null) {
                String key;
                if (visited.contains((key = getPositionKey(currentPosition)))) {
                    continue;
                }
                //标记当前节点已经被扫描
                visited.add(key);
                //到达边界位置，直接输出结果
                if (grid[currentPosition[3]][currentPosition[4]] == TARGET) {
                    return currentPosition[0];
                }
                //选择四个方向进行移动
                for (int[] nextStep : nextSteps) {
                    int nextX, nextY;
                    if (checkNotInGrid(grid, (nextX = currentPosition[1] + nextStep[0]), (nextY = currentPosition[2] + nextStep[1]))) {
                        continue;
                    }
                    if (nextX == currentPosition[3] && nextY == currentPosition[4]) {
                        int nextBoxX = currentPosition[3] + nextStep[0], nextBoxY = currentPosition[4] + nextStep[1];
                        if (checkNotInGrid(grid, nextBoxX, nextBoxY)) {
                            continue;
                        }
                        stepQueue.add(new Integer[]{currentPosition[0] + 1, nextX, nextY, nextBoxX, nextBoxY});
                    } else {
                        stepQueue.add(new Integer[]{currentPosition[0], nextX, nextY, currentPosition[3], currentPosition[4]});
                    }
                }
            }
            return -1;
        }

        private int[] findPlayerAndBox(char[][] grid) {
            int[] position = new int[4];
            boolean playerFounded = false, boxFounded = false;
            for (int i = 0; i < grid.length && !(playerFounded && boxFounded); i++) {
                for (int j = 0; j < grid[i].length && !(playerFounded && boxFounded); j++) {
                    if (grid[i][j] == PLAYER) {
                        position[0] = i;
                        position[1] = j;
                        playerFounded = true;
                    } else if (grid[i][j] == BOX) {
                        position[2] = i;
                        position[3] = j;
                        boxFounded = true;
                    }
                }
            }
            return position;
        }

        private String getPositionKey(Integer[] position) {
            return position[1] + "-" + position[2] + "-" + position[3] + "-" + position[4];
        }

        private boolean checkNotInGrid(char[][] grid, int x, int y) {
            return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == WALL;
        }
    }
}
