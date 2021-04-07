package com.changgg.algorithm.leetcode.daily;

import java.util.Stack;

/**
 * @author changgg
 * @Classname Problem768
 * @Description https://leetcode-cn.com/problems/max-chunks-to-make-sorted-ii/submissions/
 * @Date 2021/4/7 19:02
 */
public class Problem768 {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int value : arr) {
            if (stack.isEmpty()) {
                stack.push(value);
            } else {
                if (value < stack.peek()) {
                    Integer head = stack.pop();
                    while (!stack.isEmpty() && value < stack.peek()) {
                        stack.pop();
                    }
                    stack.push(head);
                } else {
                    stack.push(value);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Problem768 problem768 = new Problem768();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        System.out.println(problem768.maxChunksToSorted(arr));
        arr = new int[]{2, 1, 3, 4, 4};
        System.out.println(problem768.maxChunksToSorted(arr));
        arr = new int[]{1, 1, 0, 0, 1};
        System.out.println(problem768.maxChunksToSorted(arr));
    }
}
