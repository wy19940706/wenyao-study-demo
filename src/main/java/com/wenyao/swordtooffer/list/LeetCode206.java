package com.wenyao.swordtooffer.list;

/**
 * @Description: 翻转单向链表
 * @Author: wy
 * @CreateDate: 2019/3/6 10:49
 */
public class LeetCode206 {
    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
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
        ListNode dummy = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }

}
