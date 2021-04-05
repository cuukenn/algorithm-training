package com.changgg.algorithm.leetcode.weekly.doubleWk;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author changgg
 * @Classname Problemp0NxJO
 * @Description https://leetcode-cn.com/problems/p0NxJO/
 * @Date 2021/4/5 21:04
 */
public class Problemp0NxJO {
    public int magicTower(int[] nums) {
        int total = 1;
        for (int num : nums) {
            total += num;
        }
        if (total <= 0) {
            return -1;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        int rs = 0;
        long tmp = 1;
        for (int num : nums) {
            if (num < 0) {
                queue.add(num);
                if (tmp + num <= 0) {
                    rs++;
                    tmp -= queue.poll();
                }
            }
            tmp += num;
        }
        return rs;
    }

    public static void main(String[] args) {
        Problemp0NxJO problemp0NxJO = new Problemp0NxJO();
        int[] nums = new int[]{100, 100, 100, -250, -60, -140, -50, -50, 100, 150};
        System.out.println(problemp0NxJO.magicTower(nums));
        nums = new int[]{-200, -300, 400, 0};
        System.out.println(problemp0NxJO.magicTower(nums));
        nums = new int[]{-9635, 71923, -37495, 8366, 54303, -86422, -48303, -47858, 98424};
        System.out.println(problemp0NxJO.magicTower(nums));
        nums = new int[]{-10715, 70330, -86814, 47156, -30228, 43981, 33837, 18381, 6608};
        System.out.println(problemp0NxJO.magicTower(nums));
        nums = new int[]{4, -4, 1};
        System.out.println(problemp0NxJO.magicTower(nums));
    }
}
