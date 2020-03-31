package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * 返回链表中倒数第k个节点开始的链表
 */
public class LeetCode22 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode kthFromEnd = getKthFromEnd(head, 2);
        while (kthFromEnd != null) {
            System.out.print(kthFromEnd.value + " ");
            kthFromEnd = kthFromEnd.next;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
