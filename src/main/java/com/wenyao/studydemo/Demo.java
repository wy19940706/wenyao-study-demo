package com.wenyao.studydemo;


public class Demo {
    public static void main(String[] args) {
        SuperClass clz = new SubClass();
        System.out.println(clz.name);
    }
}


class SuperClass {
    public String name = "SuperClass";

}


class SubClass extends SuperClass {
    public String name = "SubClass";
}


