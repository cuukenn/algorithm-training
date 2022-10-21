package io.github.cuukenn.algorithm.training.leetcode.weekly.single;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author changgg
 * @Classname Problem5710
 * @Description https://leetcode-cn.com/contest/weekly-contest-233/problems/number-of-orders-in-the-backlog/
 * @Date 2021/3/21 10:39
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem5710 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        final Queue<int[]> buys = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        final Queue<int[]> shells = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] order : orders) {
            if (order[2] == 0) {
                if (shells.isEmpty()) {
                    buys.add(order);
                } else {
                    while ((order[1] != 0 || !buys.isEmpty()) && !shells.isEmpty()) {
                        int[] lowShell = shells.poll();
                        int[] bigBug = order[1] == 0 ? buys.poll() : order;
                        if (lowShell[0] <= bigBug[0]) {
                            if (lowShell[1] == bigBug[1]) {
                                order = new int[]{0, 0, 0};
                                break;
                            } else if (lowShell[1] > bigBug[1]) {
                                shells.add(new int[]{lowShell[0], lowShell[1] - bigBug[1], lowShell[2]});
                                order = new int[]{0, 0, 0};
                            } else {
                                order = new int[]{bigBug[0], bigBug[1] - lowShell[1], bigBug[2]};
                            }
                        } else {
                            buys.add(bigBug);
                            shells.add(lowShell);
                            order = new int[]{0, 0, 0};
                            break;
                        }
                    }
                    if (order[1] != 0) {
                        buys.add(order);
                    }
                }
            } else {
                if (buys.isEmpty()) {
                    shells.add(order);
                } else {
                    while (!buys.isEmpty() && (order[1] != 0 || !shells.isEmpty())) {
                        int[] bigBuy = buys.poll();
                        int[] lowShell = order[1] == 0 ? shells.poll() : order;
                        if (bigBuy[0] >= lowShell[0]) {
                            if (bigBuy[1] == lowShell[1]) {
                                order = new int[]{0, 0, 0};
                                break;
                            } else if (bigBuy[1] > lowShell[1]) {
                                buys.add(new int[]{bigBuy[0], bigBuy[1] - lowShell[1], bigBuy[2]});
                                order = new int[]{0, 0, 0};
                            } else {
                                order = new int[]{lowShell[0], lowShell[1] - bigBuy[1], lowShell[2]};
                            }
                        } else {
                            shells.add(lowShell);
                            buys.add(bigBuy);
                            order = new int[]{0, 0, 0};
                            break;
                        }
                    }
                    if (order[1] != 0) {
                        shells.add(order);
                    }
                }
            }
        }
        long rs = 0;
        while (!buys.isEmpty()) {
            rs += buys.poll()[1];
        }
        while (!shells.isEmpty()) {
            rs += shells.poll()[1];
        }
        return (int) (rs % 1000000007);
    }

    public static void main(String[] args) {
        Problem5710 problem5710 = new Problem5710();
        int[][] orders = new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
//        System.out.println(problem5710.getNumberOfBacklogOrders(orders));
        orders = new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
//        System.out.println(problem5710.getNumberOfBacklogOrders(orders));
        orders = new int[][]{{23, 17, 1}, {18, 27, 0}, {21, 26, 1}, {8, 17, 0}, {13, 22, 1}, {22, 21, 1}, {2, 24, 1}, {5, 7, 0}};
//        System.out.println(problem5710.getNumberOfBacklogOrders(orders));
        orders = new int[][]{{1, 29, 1}, {22, 7, 1}, {24, 1, 0}, {25, 15, 1}, {18, 8, 1}, {8, 22, 0}, {25, 15, 1}, {30, 1, 1}, {27, 30, 0}};
//        System.out.println(problem5710.getNumberOfBacklogOrders(orders));
        orders = new int[][]{{23, 8, 0}, {28, 29, 1}, {11, 30, 1}, {30, 25, 0}, {26, 9, 0}, {3, 21, 0}, {28, 19, 1}, {19, 30, 0}, {20, 9, 1}, {17, 6, 0}};
        System.out.println(problem5710.getNumberOfBacklogOrders(orders));
    }
}
