package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @author changgg
 * @Classname Problem264
 * @Description https://leetcode-cn.com/problems/ugly-number-ii/
 * @Date 2021/4/11 21:52
 */
public class Problem264 {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        int index = 1;
        while (!queue.isEmpty()) {
            Long poll = queue.poll();
            if (index == n) {
                return Integer.parseInt(poll + "");
            }
            if (index > n) {
                break;
            }
            if (!set.contains(poll * 2)) {
                queue.add(poll * 2);
                set.add(poll * 2);
            }
            if (!set.contains(poll * 3)) {
                queue.add(poll * 3);
                set.add(poll * 3);
            }
            if (!set.contains(poll * 5)) {
                queue.add(poll * 5);
                set.add(poll * 5);
            }
            index++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem264 problem264 = new Problem264();
        System.out.println(problem264.nthUglyNumber(1407));
        System.out.println(problem264.nthUglyNumber(10));
        System.out.println(problem264.nthUglyNumber(1));
        System.out.println(problem264.nthUglyNumber(0));
    }
}
