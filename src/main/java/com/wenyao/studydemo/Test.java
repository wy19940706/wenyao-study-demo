package com.wenyao.studydemo;

public class Test {

    public static void main(String[] args) {
        System.out.println("inner class load before");
        Inner inner = new Inner();
        inner.print();
        System.out.println("main");
    }

    private static class Inner {

        private void print() {
            System.out.println("inner static class");
        }
    }
}
