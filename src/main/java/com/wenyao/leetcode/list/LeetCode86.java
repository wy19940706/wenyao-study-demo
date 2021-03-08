package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 给定一个链表以及一个目标值， 把小于该目标值的所有节点都移至链表的前端， 大于或等于目标值的节点移至链表的尾端，同时要保持这两部分在原先链表中的相对位置
 * @Author: wy
 * @CreateDate: 2019/3/7 16:20
 */
public class LeetCode86 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        ListNode result = partition(head, 3);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    private static ListNode partition(ListNode head, int target) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.value < target) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

}
