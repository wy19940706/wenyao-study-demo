package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @author wenyao
 * @Description 奇偶链表
 * @Date 2021/3/10 下午11:59
 */
public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
