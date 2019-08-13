package com.wenyao.swordtooffer.list;

import com.google.common.collect.Lists;
import com.wenyao.leetcode.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @Description: 从尾到头打印链表
 * @Author: wy
 * @CreateDate: 2019/4/14 22:52
 */
public class SwordToOffer8 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        System.out.println(printTheListNode(head));
    }

    private static List<Integer> printTheListNode(ListNode listNode) {
        List<Integer> result = Lists.newArrayList();
        if (listNode == null) {
            return result;
        }
        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            result.add(node.value);
        }
        return result;
    }
}
