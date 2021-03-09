package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @author wenyao
 * @Description 两个链表的第一个公共节点
 * @Date 2021/3/7 上午1:06
 */
public class SwordToOffer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
