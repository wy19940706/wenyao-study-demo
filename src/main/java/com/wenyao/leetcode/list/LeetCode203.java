package com.wenyao.leetcode.list;

import com.alibaba.fastjson.JSON;
import com.wenyao.leetcode.ListNode;

/**
 * @Description: 删除链表中指定的元素(需要考虑头结点被删除的特殊情况)
 * @Author: wy
 * @CreateDate: 2019/5/20 15:00
 */
public class LeetCode203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode result2 = removeElements(head, 1);
        System.out.println(JSON.toJSONString(result2));
    }

    public static ListNode removeElements(ListNode head, int val) {
        // 用哑节点可以不用考虑头结点的特殊情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.value == val) {
                pre.next = current.next;
            } else {
                pre = pre.next;
            }
            current = current.next;
        }
        return dummy.next;
    }
}
