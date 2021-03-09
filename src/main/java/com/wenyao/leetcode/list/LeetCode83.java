package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description 删除链表的重复元素
 * @author wenyao
 * @Date 2021/3/2 下午11:53
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.value == current.next.value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


}
