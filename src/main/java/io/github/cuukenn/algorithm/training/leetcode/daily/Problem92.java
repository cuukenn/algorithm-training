package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Stack;

/**
 * @author changgg
 * @Classname Problem92
 * @Description https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Date 2021/3/18 19:29
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        Stack<ListNode> queue = new Stack<>();
        int index = 1;
        ListNode start = new ListNode(head.val), rs = start, end = null;
        while (index <= right) {
            if (index >= left) {
                queue.push(head);
            } else {
                start.next = new ListNode(head.val);
                start = start.next;
            }
            head = head.next;
            index++;
        }
        while (!queue.isEmpty() && start != null) {
            start.next = queue.pop();
            start = start.next;
        }
        if (start != null) {
            start.next = head;
        }
        return rs.next;
    }

    public void print(ListNode head) {
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Problem92 problem92 = new Problem92();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        problem92.print(problem92.reverseBetween(head, 2, 4));
        head = new ListNode(5);
        problem92.print(problem92.reverseBetween(head, 1, 1));
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        problem92.print(problem92.reverseBetween(head, 3, 3));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
