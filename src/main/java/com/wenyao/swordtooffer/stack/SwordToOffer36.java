package com.wenyao.swordtooffer.stack;

import java.util.Stack;

/**
 * @Description: 栈的压入，弹出序列
 * @Author: wy
 * @CreateDate: 2019/4/15 23:13
 */
public class SwordToOffer36 {
    public static void main(String[] args) {
        int[] pushSeq = new int[]{1, 2, 3, 4, 5};
        int[] popSeq = new int[]{4, 5, 3, 2, 1};
        int[] array = new int[]{4, 3, 5, 1, 2};
        System.out.println(isPopOrder(pushSeq, popSeq));
        System.out.println(isPopOrder(pushSeq, array));
    }

    private static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
        int length = pushSeq.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < length; i++) {
            stack.push(pushSeq[i]);
            while (j < length && !stack.isEmpty() && stack.peek() == popSeq[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
