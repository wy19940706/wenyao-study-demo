package com.wenyao.swordtooffer.list;

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
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        ListNode result = removeOfTarget(head, 1);
        System.out.println(JSON.toJSONString(result));
    }

    private static ListNode removeOfTarget(ListNode head, int target) {
        if (head == null) {
            return null;
        }
        while (head != null && head.value == target) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.value == target) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
