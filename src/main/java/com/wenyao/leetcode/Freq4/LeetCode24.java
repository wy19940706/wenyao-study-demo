package com.wenyao.leetcode.Freq4;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 给定一个单链表，成对交换两个相邻的结点
 * @Author: wy
 * @CreateDate: 2019/3/17 22:30
 */
public class LeetCode24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode result = swapPairs(listNode);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode tmp;
        while (p.next != null && p.next.next != null) {
            tmp = p.next.next;
            p.next.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;
            p = tmp.next;
        }
        head = dummy.next;
        dummy.next = null;
        return head;
    }
}
