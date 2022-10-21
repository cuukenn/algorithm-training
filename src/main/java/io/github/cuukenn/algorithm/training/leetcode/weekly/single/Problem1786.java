package io.github.cuukenn.algorithm.training.leetcode.weekly.single;

/**
 * @author changgg
 * @Classname Problem1786
 * @Description https://leetcode-cn.com/contest/weekly-contest-231/problems/number-of-restricted-paths-from-first-to-last-node/
 * @Date 2021/3/20 14:48
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem1786 {
    //TODO DSF执行超时
    public int countRestrictedPaths(int n, int[][] edges) {
        final int[][] ds = new int[n][n];
        for (int[] edge : edges) {
            ds[edge[0] - 1][edge[1] - 1] = edge[2];
            ds[edge[1] - 1][edge[0] - 1] = edge[2];
        }
        boolean[] visited = new boolean[n];
        return dsf(dijkstra(ds, n, n), ds, 0, visited);
    }

    private int[] dijkstra(int[][] ds, int n, int target) {
        //已经访问的点
        final boolean[] visited = new boolean[n];
        //最终距离
        final int[] dist = new int[n];
        visited[target - 1] = true;
        //初始化与N连接的点长度
        for (int index = 0; index < n; index++) {
            if (index == n - 1) {
                continue;
            }
            dist[index] = ds[index][n - 1];
        }
        while (true) {
            //获取长度最短且未被访问的点
            int index = -1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] > 0) {
                    if (index == -1) {
                        index = i;
                    } else {
                        index = dist[i] > dist[index] ? index : i;
                    }
                }
            }
            if (index == -1) {
                break;
            }
            visited[index] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && ds[index][i] > 0) {
                    int tmp = dist[index] + ds[index][i];
                    if (dist[i] <= 0) {
                        dist[i] = tmp;
                    } else if (tmp < dist[i]) {
                        dist[i] = tmp;
                    }
                }
            }
        }
        return dist;
    }

    private int dsf(int[] dist, int[][] ds, int startIndex, boolean[] visited) {
        final int n = dist.length;
        if (startIndex == n - 1) {
            return 1;
        }
        int rs = 0;
        for (int index = 0; index < dist.length; index++) {
            visited[startIndex] = true;
            if (!visited[index] && ds[startIndex][index] != 0 && dist[startIndex] > dist[index]) {
                visited[index] = true;
                rs += dsf(dist, ds, index, visited);
                visited[index] = false;
            }
            visited[startIndex] = false;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problem1786 problem1786 = new Problem1786();
        int[][] edges = new int[][]{
                {1, 2, 3}, {1, 3, 3}, {2, 3, 1}, {1, 4, 2}, {5, 2, 2}, {3, 5, 1}, {5, 4, 10}
        };
        System.out.println(problem1786.countRestrictedPaths(5, edges));
        edges = new int[][]{
                {1, 3, 1}, {4, 1, 2}, {7, 3, 4}, {2, 5, 3}, {5, 6, 1}, {6, 7, 2}, {7, 5, 3}, {2, 6, 4}
        };
        System.out.println(problem1786.countRestrictedPaths(7, edges));
        edges = new int[][]{{9, 10, 8}, {9, 6, 5}, {1, 5, 9}, {6, 8, 10}, {1, 8, 1}, {8, 10, 7}, {10, 7, 9}, {5, 7, 3}, {4, 2, 9}, {2, 3, 9}, {3, 10, 4}, {1, 4, 7}, {7, 6, 1}, {3, 9, 8}, {9, 1, 6}, {4, 7, 10}, {9, 4, 9}};
        System.out.println(problem1786.countRestrictedPaths(10, edges));
    }
}
