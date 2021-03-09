package com.wenyao.studydemo;

/**
 * Created by Think on 2019/5/19
 */
public class IntegerCache {
    public static void main(String[] args) {
        Integer a = 150;
        Integer b = 150;
        System.out.println(a == b);

        int a1 = 190;
        int b1 = 190;
        System.out.println(a1 == b1);

        Integer a2 = 2;
        Integer b2 = 2;
        System.out.println(a2 == b2);

        Integer a3 = new Integer(100);
        Integer b3 = new Integer(100);
        System.out.println(a3 == b3);

        Integer a4 = Integer.valueOf(100);
        Integer b4 = Integer.valueOf(100);
        System.out.println(a4 == b4);

        Integer a5 = Integer.valueOf(129);
        Integer b5 = Integer.valueOf(129);
        System.out.println(a5 == b5);
    }

}
