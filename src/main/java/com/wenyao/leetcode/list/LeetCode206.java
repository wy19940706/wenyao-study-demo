package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 翻转单向链表
 * @Author: wy
 * @CreateDate: 2019/3/6 10:49
 */
public class LeetCode206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        // ListNode resultList = reverseListByRecursion(head);
        ListNode resultList = reverseListNode(head);
        while (resultList != null) {
            System.out.print(resultList.value + " ");
            resultList = resultList.next;
        }
    }

    private static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * 递归翻转单链表
     * 
     * @param head 递归三要素：1.使用递归来实现什么功能 2.寻找递归结束条件（压缩至最小值进行寻找） 3.寻找等价关系
     * @return
     */
    private static ListNode reverseListByRecursion(ListNode head) {
        // 寻找递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 把head.next先翻转过来
        ListNode newList = reverseListByRecursion(head.next);
        // 把第二个节点的next翻转过来
        head.next.next = head;
        // 把head.next置为null
        head.next = null;
        return newList;
    }

}
