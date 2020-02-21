package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * 两个链表相交的起始节点
 * 解题思路：headA走到终点再去走headB,headB走到终点再去走heaA，两个人会相遇然后同时走完
 */
public class LeetCode160 {
    public static void main(String[] args) {
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
