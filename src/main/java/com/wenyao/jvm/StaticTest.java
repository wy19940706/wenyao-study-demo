package com.wenyao.jvm;

/**
 * 考察的重点就是 把类变量的实例化嵌入了静态变量的初始化之前
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

    // 这一步的时候其实所有的static变量都已经完成了准备阶段（准备阶段不应该是代码中体现的，代码中都已经是初始化的阶段了）
    // 所以这一行是初始化st变量的过程了，但是此时又引发了StaticTest的构造器，就让实例化跑到了static变量初始化阶段的前面去了
    // 如果变量加了final就会在准备阶段就完成初始化
    static StaticTest st = new StaticTest();

    int a = 110;
    // final会让b在准备阶段就置为112；如果此处没有final，b的值在下面的构造器中打印就会是0，因为没有被初始化
    static final int b = 112;

    static {
        System.out.println("1");
        System.out.println(b);
    }

    // 这一步之前会先去初始化成员变量和非静态代码块 故会把a置为110
    StaticTest() {
        System.out.println("3");
        // b在这里为什么是0? 就是因为b在准备阶段被赋了0值，还没有被初始化成112之前被new StaticTest()实例化过程嵌入了
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    {
        System.out.println("2");
    }

}
