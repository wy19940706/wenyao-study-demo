package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序(归并排序)
 * @Author: wy
 * @CreateDate: 2019/4/16 0:22
 */
public class LeetCode148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(sortList(head));
    }

    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 获取后半段链表
        ListNode tmp = slow.next;
        // 把两段链表断开
        slow.next = null;
        // 对前半段排序
        ListNode l1 = sortList(head);
        // 对后半段排序
        ListNode l2 = sortList(tmp);
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 != null ? l1 : l2;
        return dummy.next;
    }
}
