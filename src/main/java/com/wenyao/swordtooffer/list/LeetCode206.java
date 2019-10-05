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
        ListNode resultList = reverseListByRecursion(head);
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
        ListNode newList = reverseListByRecursion(head.next);
        ListNode node2 = head.next;
        node2.next = head;
        head.next = null;
        return newList;
    }

}
