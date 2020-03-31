package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * 旋转链表
 */
public class LeetCode61 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(rotateRight(head, 2));
    }

    // 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    // 示例 1:
    // 输入: 1->2->3->4->5->NULL, k = 2
    // 输出: 4->5->1->2->3->NULL
    // 解释:
    // 向右旋转 1 步: 5->1->2->3->4->NULL
    // 向右旋转 2 步: 4->5->1->2->3->NULL
    // 时间复杂度：O(n)-其中n是链表中的元素个数 空间复杂度：O(1)
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oldTail = head;
        int n;
        for (n = 1; oldTail.next != null; n++) {
            oldTail = oldTail.next;
        }
        oldTail.next = head;
        ListNode newTail = head;
        for (int i = 1; i < n - k % n - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}
