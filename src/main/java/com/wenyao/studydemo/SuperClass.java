package com.wenyao.studydemo;


public class SuperClass {

    private String superName = "superName";

    private static String superStaticName = "superStaticName";

    static {
        System.out.println(superStaticName);
        System.out.println("super static block");
    }

    {
        System.out.println("super block");
    }

    private SuperClass() {
        System.out.println(superName);
        System.out.println("super constructor");
    }

    static class SubClass extends SuperClass {

        private String subName = "subName";
        private static String subStaticName = "subStaticName";

        static {
            System.out.println(subStaticName);
            System.out.println("sub static block");
        }

        {
            System.out.println("sub block");
        }

        private SubClass() {
            System.out.println(subName);
            System.out.println("sub constructor");
        }
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
    }
}


