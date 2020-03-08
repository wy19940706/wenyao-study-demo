package com.wenyao.leetcode.list;

import com.alibaba.fastjson.JSON;
import com.wenyao.leetcode.ListNode;

/**
 * @Description: 链表中环的入口节点（leetcode142）
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
        ListNode nodeOfLoop = detectCycle(head);
        System.out.println(JSON.toJSONString(nodeOfLoop));
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
