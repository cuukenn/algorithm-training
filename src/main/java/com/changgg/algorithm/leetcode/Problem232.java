package com.changgg.algorithm.leetcode;

import java.util.Stack;

/**
 * see:https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author changgg
 */
public class Problem232 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public Problem232() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        this.stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        stack2.clear();
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int rs = stack2.pop();
        stack1.clear();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return rs;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        stack2.clear();
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        int rs = stack2.peek();
        stack1.clear();
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        return rs;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty();
    }

    public static void main(String[] args) {
        Problem232 problem232 = new Problem232();
        problem232.push(1);
        problem232.push(2);
        System.out.println(problem232.peek());
        System.out.println(problem232.pop());
        System.out.println(problem232.empty());
    }
}
