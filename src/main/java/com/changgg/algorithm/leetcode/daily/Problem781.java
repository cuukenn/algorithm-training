package com.changgg.algorithm.leetcode.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author changgg
 * @Classname Problem781
 * @Description https://leetcode-cn.com/problems/rabbits-in-forest/submissions/
 * @Date 2021/4/4 13:27
 */
public class Problem781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        AtomicInteger result = new AtomicInteger(0);
        for (int an : answers) {
            map.compute(an, (key, old) -> {
                if (old != null) {
                    return old + 1;
                } else {
                    return 1;
                }
            });
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int a = value / (key + 1);
            int b = value % (key + 1);
            result.getAndAdd((key + 1) * a);
            if (b > 0) {
                result.getAndAdd(key + 1);
            }
        }
        return result.get();
    }

    public static void main(String[] args) {
        Problem781 problem781 = new Problem781();
        int[] answers = new int[]{1, 1, 2};
        System.out.println(problem781.numRabbits(answers));
        answers = new int[]{10, 10, 10};
        System.out.println(problem781.numRabbits(answers));
        answers = new int[]{0, 0, 1, 1, 1};
        System.out.println(problem781.numRabbits(answers));
        answers = new int[]{1, 0, 1, 0, 0};
        System.out.println(problem781.numRabbits(answers));
        answers = new int[]{};
        System.out.println(problem781.numRabbits(answers));
    }
}
