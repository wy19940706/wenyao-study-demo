package com.wenyao.leetcode.string;

/**
 * @author wenyao
 * @Description 左旋转字符串
 * @Date 2021/3/7 上午1:18
 */
public class SwordToOffer58 {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}
