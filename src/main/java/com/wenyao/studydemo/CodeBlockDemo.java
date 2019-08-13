package com.wenyao.studydemo;

public class CodeBlockDemo {
    {
        System.out.println("初始化代码");
    }

    CodeBlockDemo() {
        System.out.println("构造器");
    }

    static {
        System.out.println("静态代码块");
    }

    public static void main(String[] args) {
        {
            int a = 10;
            System.out.println(a);
            // 10
            System.out.println("局部代码块");
        }

        new CodeBlockDemo();
        new CodeBlockDemo();
        new CodeBlockDemo();
    }
}
