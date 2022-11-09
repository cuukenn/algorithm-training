package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author changgg
 * @see <a href="https://leetcode.cn/problems/largest-plus-sign/">leetcode764</a>
 */
public class LtCode764 {
    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        {
            System.out.println("暴力遍历");
            SolutionHardSearch solution = new SolutionHardSearch();
            System.out.println(solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
            System.out.println(solution.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
            System.out.println(solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}));
            System.out.println(solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {1, 1}}));
            System.out.println(solution.orderOfLargestPlusSign(10, new int[][]{{0, 0}, {0, 5}, {1, 2}, {1, 9}, {2, 5}, {2, 8}, {3, 1}, {3, 6}, {5, 0}, {6, 1}, {6, 4}, {6, 6}, {6, 8}, {7, 8}, {7, 9}, {8, 1}, {8, 8}, {9, 0}, {9, 1}, {9, 2}, {9, 4}, {9, 5}, {9, 6}}));
            System.out.println(solution.orderOfLargestPlusSign(3, new int[][]{{0, 2}, {1, 0}, {2, 0}}));
        }
        {
            System.out.println("动态规划");
            SolutionDp solution = new SolutionDp();
            System.out.println(solution.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
            System.out.println(solution.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
            System.out.println(solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}));
            System.out.println(solution.orderOfLargestPlusSign(2, new int[][]{{0, 0}, {1, 1}}));
            System.out.println(solution.orderOfLargestPlusSign(10, new int[][]{{0, 0}, {0, 5}, {1, 2}, {1, 9}, {2, 5}, {2, 8}, {3, 1}, {3, 6}, {5, 0}, {6, 1}, {6, 4}, {6, 6}, {6, 8}, {7, 8}, {7, 9}, {8, 1}, {8, 8}, {9, 0}, {9, 1}, {9, 2}, {9, 4}, {9, 5}, {9, 6}}));
            System.out.println(solution.orderOfLargestPlusSign(3, new int[][]{{0, 2}, {1, 0}, {2, 0}}));
        }
    }

    /**
     * 暴力搜索
     * unresolved
     * 超时
     */
    static class SolutionHardSearch {

        public int orderOfLargestPlusSign(int n, int[][] mines) {
            final Set<String> set = new HashSet<>(mines.length);
            for (int[] mine : mines) {
                set.add((mine[0] + "," + mine[1]));
            }
            int rs = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int[] mine = new int[]{x, y};
                    //从当前节点出发选择周围的点作为中心点进行计算
                    int r1 = orderOfLargestPlusSign(n, set, new int[]{mine[0] - 1, mine[1] - 1});
                    int r2 = orderOfLargestPlusSign(n, set, new int[]{mine[0] - 1, mine[1] + 1});
                    int r3 = orderOfLargestPlusSign(n, set, new int[]{mine[0] + 1, mine[1] + 1});
                    int r4 = orderOfLargestPlusSign(n, set, new int[]{mine[0] + 1, mine[1] - 1});
                    int r5 = orderOfLargestPlusSign(n, set, new int[]{mine[0], mine[1] - 1});
                    int r6 = orderOfLargestPlusSign(n, set, new int[]{mine[0], mine[1] + 1});
                    int r7 = orderOfLargestPlusSign(n, set, new int[]{mine[0] + 1, mine[1]});
                    int r8 = orderOfLargestPlusSign(n, set, new int[]{mine[0] + 1, mine[1]});
                    rs = Math.max(r1, rs);
                    rs = Math.max(r2, rs);
                    rs = Math.max(r3, rs);
                    rs = Math.max(r4, rs);
                    rs = Math.max(r5, rs);
                    rs = Math.max(r6, rs);
                    rs = Math.max(r7, rs);
                    rs = Math.max(r8, rs);
                }
            }
            return rs;
        }

        private int orderOfLargestPlusSign(int n, Set<String> mines, int[] pointer) {
            //校验中心点位置
            if (!valid(n, pointer)) {
                return 0;
            }
            if (mines.contains(pointer[0] + "," + pointer[1])) {
                return 0;
            }
            int rs = 0;
            while (true) {
                //计算外扩一次
                int[] p1 = new int[]{pointer[0], pointer[1] - rs - 1};
                int[] p2 = new int[]{pointer[0], pointer[1] + rs + 1};
                int[] p3 = new int[]{pointer[0] + rs + 1, pointer[1]};
                int[] p4 = new int[]{pointer[0] - rs - 1, pointer[1]};
                if (validAndNotMine(mines, n, p1) && validAndNotMine(mines, n, p2) && validAndNotMine(mines, n, p3) && validAndNotMine(mines, n, p4)) {
                    rs++;
                } else {
                    break;
                }
            }
            return rs + 1;
        }

        private boolean valid(int n, int[] pointer) {
            return pointer[0] >= 0 && pointer[0] < n && pointer[1] >= 0 && pointer[1] < n;
        }

        private boolean validAndNotMine(Set<String> mines, int n, int[] pointer) {
            return valid(n, pointer) && !mines.contains((pointer[0] + "," + pointer[1]));
        }
    }

    /**
     * map[n][n]
     * dp(x,y,z),z -> N[0,3] x -> N[0,n) y -> N[0,n)
     * dp(x,y,0)=dp(x-1,y,0)+1 or 0
     * dp(x,y,1)=dp(x,y+1,1)+1 or 0
     * dp(x,y,2)=dp(x+1,y,2)+1 or 0
     * dp(x,y,3)=dp(x,y-1,3)+1 or 0
     * <p>
     * z(x,y)=min( dp(x,y,0),dp(x,y,1),dp(x,y,2),dp(x,y,3) )
     * rs=max ( z(0,0),z(0,1)...,z(x,y) ) ,x -> N[0,n) y -> N[0,n)
     */
    static class SolutionDp {

        public int orderOfLargestPlusSign(int n, int[][] mines) {
            final int[][] map = new int[n][n];
            for (int[] item : map) {
                Arrays.fill(item, 1);
            }
            for (int[] mine : mines) {
                map[mine[0]][mine[1]] = 0;
            }
            final int[][][] dp = new int[n][n][4];
            //初始化方向矩阵
            for (int x = 0; x < n; x++) {
                //left
                for (int y = 0, cn = 0; y < n; y++) {
                    if (map[x][y] == 1) {
                        cn++;
                    } else {
                        cn = 0;
                    }
                    dp[x][y][3] = cn;
                }
                //right
                for (int y = n - 1, cn = 0; y >= 0; y--) {
                    if (map[x][y] == 1) {
                        cn++;
                    } else {
                        cn = 0;
                    }
                    dp[x][y][1] = cn;
                }
            }
            for (int y = 0; y < n; y++) {
                //top
                for (int x = 0, cn = 0; x < n; x++) {
                    if (map[x][y] == 1) {
                        cn++;
                    } else {
                        cn = 0;
                    }
                    dp[x][y][0] = cn;
                }
                //bottom
                for (int x = n - 1, cn = 0; x >= 0; x--) {
                    if (map[x][y] == 1) {
                        cn++;
                    } else {
                        cn = 0;
                    }
                    dp[x][y][2] = cn;
                }
            }
            int rs = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int tmp = Math.min(dp[x][y][0], dp[x][y][1]);
                    tmp = Math.min(tmp, dp[x][y][2]);
                    tmp = Math.min(tmp, dp[x][y][3]);
                    rs = Math.max(rs, tmp);
                }
            }
            return rs;
        }
    }
}
