package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * @Description: 给定一个单链表，成对交换两个相邻的结点（如：1->2->3->4 得到2->1->4->3）
 * @Author: wy
 * @CreateDate: 2019/3/17 22:30
 */
public class LeetCode24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode result = swapPairs(listNode);
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }

    // temp->start->end->end.next
    public static ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    /**
     * 递归解法 前->head->next->后 返回值：交换完成的next,因为他是交换后的新头结点 调用单元：设需要交换的两个点为 head 和 next，head
     * 连接后面交换完成的子链表，next 连接 head，完成交换 终止条件：head 为空指针或者 next 为空指针，也就是当前无节点或者只有一个节点，无法进行交换
     *
     * @param head
     * @return
     */
    public ListNode swapPairsByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

}
