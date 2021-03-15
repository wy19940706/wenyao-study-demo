package com.wenyao.leetcode.dp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wenyao
 * @Description
 * @Date 2021/3/12 下午8:09
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(test("1.1.1.1"));
    }

    // 写一个函数将 ipv4 地址字符串 (仅包含数字，点，空格) 转化成 32 位整数，另外，数字和点之间的空格是合法的，其他情况均为非法地址，要求输出合法地址的 32 位整型结果。
    // “a.b.c.d”->int32 “1.1.1.1” -> 16843009 “1.1.1.1” -> 00000001000000010000000100000001 -> 16843009
    // “1.2.3.4” -> 00000001 00000010 00000011 00000100 -> 16909060
    // 1. 考虑各类输入 2. 考虑边界条件 3. 尽量高效
    public static int test(String address) {
        if (address == null || address.length() == 0) {
            return -1;
        }

        // TODO: 2021/3/12

        List<Integer> ipList = Stream.of(address.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());
        if (ipList.size() != 4) {
            return -1;
        }
        int sum = 0;
        for (int i = ipList.size() - 1; i >= 0; i--) {
            Integer integer = ipList.get(i);
            if (integer < 0 || integer > 255) {
                return -1;
            }
            int temp = integer << (8 * i);
            sum += temp;
        }
        return sum;
    }



}
