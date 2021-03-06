package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 判断一个链表是否有环
 * @Author: wy
 * @CreateDate: 2019/3/7 16:02
 */
public class LeetCode141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node3.next = head;
        boolean result = hasCycle(head);
        System.out.println(result);
    }

    private static boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
