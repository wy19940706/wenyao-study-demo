package com.wenyao.swordtooffer.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 从m-n的位置翻转链表
 * @Author: wy
 * @CreateDate: 2019/3/7 12:40
 */
public class LeetCode92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode result = reverseBetween(head, 2, 4);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            ListNode start = pre.next;
            ListNode then = start.next;
            for (int j = 0; j < n - m; j++) {
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
        }
        return dummy.next;
    }
}
