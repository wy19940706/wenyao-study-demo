package com.wenyao.leetcode.list;

import com.wenyao.leetcode.ListNode;

/**
 * 对链表进行插入排序
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 定义三个指针 pre, cur, next
        // pre cur next
        // h -> 4 -> 2 -> 5 -> 3 -> null

        // 创建 h 节点，用于遍历链表
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next; // 记录下一个要插入排序的值
            if (next != null && next.value < cur.value) { // 只有 cur.next 比 cur 小才需要向前寻找插入点
                // 寻找插入点，从 pre 开始遍历 （每次都是头节点 dummy 开始向后遍历，因为单向链表是无法从后往前遍）
                while (pre.next != null && pre.next.value < next.value) { // 如果当前节点的值小于要插入排序的值
                    pre = pre.next; // 继续向后移动
                }
                // 找到要插入的位置，此时 pre 节点后面的位置就是 next 要插入的位置
                ListNode tmp = pre.next;
                // 在 pre 节点后面插入
                pre.next = next;
                // 此时 cur 节点还是 pre 所在的节点，所以其 next 要指向插入节点 next 指向的 next
                cur.next = next.next;
                // 插入next节点后，把记录的原先插入位置后续的 next 节点传给它，注意与上一行的顺序
                next.next = tmp;
                // 由于每次都是从前往后找插入位置，但是单向链表是无法从后往前遍历，所以需要每次插入完成后要让 pre 复位
                pre = dummy;
            } else {
                // 都这直接把 cur 指针指向到下一个
                cur = next;
            }
        }
        return dummy.next;
    }

}
