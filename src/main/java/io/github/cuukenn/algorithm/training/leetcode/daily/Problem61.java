package io.github.cuukenn.algorithm.training.leetcode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changgg
 * @Classname Problem61
 * @Description https://leetcode-cn.com/problems/rotate-list/submissions/
 * @Date 2021/3/27 12:52
 * @link https://github.com/love390
 * @link https://gitee.com/cgggitee
 */
public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        final List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        final Integer[] arrays = list.toArray(new Integer[0]);
        final int size = arrays.length;
        Integer[] rotateArrays = new Integer[size];
        for (int index = 0; index < size; index++) {
            rotateArrays[(index + k) % size] = arrays[index];
        }
        ListNode rs = new ListNode(0), tmp = rs;
        for (Integer rotateArray : rotateArrays) {
            ListNode newNode = new ListNode(rotateArray);
            tmp.next = newNode;
            tmp = newNode;
        }
        return rs.next;
    }

    private void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        Problem61 problem61 = new Problem61();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        problem61.print(problem61.rotateRight(listNode1, 2));

        listNode1 = new ListNode(0);
        listNode2 = new ListNode(1);
        listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        problem61.print(problem61.rotateRight(listNode1, 4));
    }
}
