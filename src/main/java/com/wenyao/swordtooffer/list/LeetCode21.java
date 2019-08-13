package com.wenyao.swordtooffer.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 合并两个有序链表
 * @Author: wy
 * @CreateDate: 2019/3/17 23:06
 */
public class LeetCode21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode result = mergeList(list1, list2);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    private static ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curreny = head;
        while (l1 != null && l2 != null) {
            if (l1.value >= l2.value) {
                curreny.next = l2;
                l2 = l2.next;
            } else {
                curreny.next = l1;
                l1 = l1.next;
            }
            curreny = curreny.next;
        }
        if (l1 != null) {
            curreny.next = l1;
        }
        if (l2 != null) {
            curreny.next = l2;
        }
        return head.next;
    }
}
