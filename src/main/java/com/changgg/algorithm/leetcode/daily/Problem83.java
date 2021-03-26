package com.changgg.algorithm.leetcode.daily;

import java.util.Stack;

/**
 * @author changgg
 * @Classname Problem
 * @Description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @Date 2021/3/26 19:24
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            while (!stack.isEmpty()) {
                if (stack.peek() == head.val) {
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(head.val);
            head = head.next;
        }
        ListNode rs = null;
        while (!stack.isEmpty()) {
            ListNode listNode = new ListNode(stack.pop());
            listNode.next = rs;
            rs = listNode;
        }
        return rs;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Problem83 problem83 = new Problem83();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        problem83.print(problem83.deleteDuplicates(listNode1));
    }
}
