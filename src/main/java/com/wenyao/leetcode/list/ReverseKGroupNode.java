package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * 从头结点开始以k个节点为一组进行逆序，不足一组则不调整
 */
public class ReverseKGroupNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        ListNode newListByHead = reverseKGroupByHead(head, 3);
        while (newListByHead != null) {
            System.out.print(newListByHead.value + " ");
            newListByHead = newListByHead.next;
        }

        // ListNode newListByTail = reverseKGroupByTail(head, 3);
        // while (newListByTail != null) {
        // System.out.print(newListByTail.value + " ");
        // newListByTail = newListByTail.next;
        // }
    }

    /**
     * 从尾节点开始k个节点为一组进行逆序
     * 
     * @param head
     * @param k
     * @return
     */
    private static ListNode reverseKGroupByTail(ListNode head, int k) {
        head = reverseListNode(head);
        head = reverseKGroupByHead(head, k);
        head = reverseListNode(head);
        return head;
    }

    private static ListNode reverseKGroupByHead(ListNode head, int k) {
        ListNode temp = head;
        // 得到一组节点的最后一个节点
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        // 如果节点不足以组成一组，则返回head不调整
        if (temp == null) {
            return head;
        }
        // 保存下一组节点的头结点
        ListNode t2 = temp.next;
        // 与下一组的节点断开
        temp.next = null;
        // 把当前组进行逆序
        ListNode newHead = reverseListNode(head);
        // 将下一组节点进行逆序
        ListNode newTemp = reverseKGroupByHead(t2, k);
        // 将分组逆序之后的节点连接起来
        head.next = newTemp;
        return newHead;
    }

    private static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = reverseListNode(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }
}
