package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.Stack;

/**
 * @author changgg
 * @Classname Problem82
 * @Description https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/submissions/
 * @Date 2021/3/25 18:50
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        final Stack<Integer> stack = new Stack<>();
        while (true) {
            boolean shouldRemove = false;
            while (!stack.isEmpty()) {
                if (head != null && stack.peek() == head.val) {
                    shouldRemove = true;
                    head = head.next;
                } else {
                    break;
                }
            }
            if (shouldRemove) {
                stack.pop();
            }
            if (head == null) {
                break;
            }
            stack.push(head.val);
            if (head.next == null) {
                break;
            }
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

    private void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        Problem82 problem82 = new Problem82();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        problem82.print(problem82.deleteDuplicates(listNode1));
        listNode1 = new ListNode(1);
        listNode2 = new ListNode(1);
        listNode3 = new ListNode(1);
        listNode4 = new ListNode(2);
        listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        problem82.print(problem82.deleteDuplicates(listNode1));
        listNode1 = new ListNode(1);
        listNode2 = new ListNode(1);
        listNode1.next = listNode2;
        problem82.print(problem82.deleteDuplicates(listNode1));
    }
}
