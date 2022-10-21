package io.github.cuukenn.algorithm.training.leetcode.daily;

/**
 * @author changgg
 * @Classname Problem1020
 * @Description https://leetcode-cn.com/problems/number-of-enclaves/submissions/
 * @Date 2021/3/26 22:57
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1020 {
    public int numEnclaves(int[][] grid) {
        int w = grid[0].length, h = grid.length, color = 1;
        final boolean[][] painted = new boolean[h][w];
        //TOP
        for (int i = 0; i < w; i++) {
            dsf(grid, painted, 0, i, h, w);
        }
        //LEFT
        for (int i = 0; i < h; i++) {
            dsf(grid, painted, i, 0, h, w);
        }
        //BOTTOM
        for (int i = 0; i < w; i++) {
            dsf(grid, painted, h - 1, i, h, w);
        }
        //RIGHT
        for (int i = 0; i < h; i++) {
            dsf(grid, painted, i, w - 1, h, w);
        }
        int rs = 0;
        for (int i = 1; i < h - 1; i++) {
            for (int j = 1; j < w - 1; j++) {
                if (grid[i][j] == 1 && !painted[i][j]) {
                    rs++;
                }
            }
        }
        return rs;
    }

    private void dsf(int[][] grid, boolean[][] painted, int x, int y, int h, int w) {
        if (grid[x][y] == 0 || painted[x][y]) {
            return;
        }
        painted[x][y] = true;
        //TOP
        if (x - 1 >= 0) {
            dsf(grid, painted, x - 1, y, h, w);
        }
        //LEFT
        if (y - 1 >= 0) {
            dsf(grid, painted, x, y - 1, h, w);
        }
        //BOTTOM
        if (x + 1 < h) {
            dsf(grid, painted, x + 1, y, h, w);
        }
        //RIGHT
        if (y + 1 < w) {
            dsf(grid, painted, x, y + 1, h, w);
        }
    }

    public static void main(String[] args) {
        Problem1020 problem1020 = new Problem1020();
        int[][] grid = new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println(problem1020.numEnclaves(grid));
        grid = new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(problem1020.numEnclaves(grid));
        grid = new int[][]{{0}, {1}, {1}, {0}, {0}};
        System.out.println(problem1020.numEnclaves(grid));
        grid = new int[][]{{0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0}, {0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1}};
        System.out.println(problem1020.numEnclaves(grid));
    }
}
