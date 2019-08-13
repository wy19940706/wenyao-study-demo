package com.wenyao.swordtooffer.list;

import com.alibaba.fastjson.JSON;
import com.wenyao.leetcode.ListNode;

/**
 * @Description: 链表中环的入口节点
 * @Author: wy
 * @CreateDate: 2019/4/2 15:39
 */
public class SwordToOffer9 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;
        ListNode nodeOfLoop = searchNodeOfLoop(head);
        System.out.println(JSON.toJSONString(nodeOfLoop));
    }

    private static ListNode searchNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
