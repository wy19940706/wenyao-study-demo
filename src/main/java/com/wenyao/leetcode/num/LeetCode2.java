package com.wenyao.leetcode.num;

/**
 * @Description: 给你2个链表，代表2个非负整数。链表中整数的每一位数字的存储是反序的，数组的每个节点都包含一个数字。 把2个非负整数相加，并且用一个链表返回。 输入: (2 -> 4
 *               -> 3) + (5 -> 6 -> 4) 输出: 7 -> 0 -> 8
 * @Author: wy
 * @CreateDate: 2019/1/13 23:00
 */
public class LeetCode2 {

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        // listNode1.next.next = new ListNode(3);
        ListNode listNode2 = new ListNode(1);
        // listNode2.next = new ListNode(6);
        // listNode2.next.next = new ListNode(4);
        ListNode resultListNode = addTwoNums(listNode1, listNode2);
        addTwoNumbers(listNode1, listNode2);
        while (resultListNode != null) {
            System.out.print(resultListNode.value);
            resultListNode = resultListNode.next;
        }
    }

    private static ListNode addTwoNums(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        int fix = 0;
        while (list1 != null || list2 != null || fix != 0) {
            int value1 = 0;
            int value2 = 0;
            if (list1 != null) {
                value1 = list1.value;
                list1 = list1.next;
            }
            if (list2 != null) {
                value2 = list2.value;
                list2 = list2.next;
            }
            int sum = value1 + value2 + fix;
            fix = 0;
            if (sum > 9) {
                fix = 1;
                sum -= 10;
            }
            current.next = new ListNode(0);
            current.next.value = sum;
            current = current.next;
        }
        return head.next;
    }

    // 时间复杂度：O(Max(m,n)) 空间复杂度：O(Max(m,n)) m,n分表表示两个链表的长度
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int x = p != null ? p.value : 0;
            int y = q != null ? q.value : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
