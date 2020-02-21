package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 两个链表的第一个公共节点
 * @Author: wy
 * @CreateDate: 2019/3/26 22:18
 */
public class SwordToOffer51 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode commonNode1 = new ListNode(3);
        ListNode commonNode2 = new ListNode(5);
        listNode1.next = commonNode1;
        commonNode1.next = commonNode2;
        ListNode listNode2 = new ListNode(2);
        listNode2.next = commonNode1;
        commonNode1.next = commonNode2;
        ListNode result = theFirstCommonNode(listNode1, listNode2);
        System.out.println(result.value);
    }

    private static ListNode theFirstCommonNode(ListNode listNode1, ListNode listNode2) {
        ListNode pHead1 = listNode1;
        ListNode pHead2 = listNode2;
        while (pHead1 != pHead2) {
            pHead1 = (pHead1 == null) ? listNode2 : pHead1.next;
            pHead2 = (pHead2 == null) ? listNode1 : pHead2.next;
        }
        return pHead1;
    }
}
