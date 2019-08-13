package com.wenyao.singleinstancemode;

/**
 * Created by Think on 2019/1/3
 */

import java.util.concurrent.atomic.AtomicReference;

/**
 * 饿汉式单列模式，线程安全
 */
public class SingleTest {

    public static class SingleInstance {
        private static final SingleInstance instance = new SingleInstance();

        private SingleInstance() {
        }

        public static SingleInstance getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式单例模式，非线程安全
     */
    public static class SingleInstance2 {
        private static SingleInstance2 instance2 = null;

        private SingleInstance2() {
        }

        public static SingleInstance2 getInstance2() {
            instance2 = new SingleInstance2();
            return instance2;
        }
    }

    /**
     * 加锁懒汉式单例模式，线程安全
     */
    public static class SingleInstance3 {
        private static SingleInstance3 instance3 = null;

        private SingleInstance3() {
        }

        public static synchronized SingleInstance3 getInstance3() {
            instance3 = new SingleInstance3();
            return instance3;
        }
    }

    /**
     * 静态代码块初始化懒汉式单例模式，线程安全
     */
    public static class SingleInstance4 {
        private static SingleInstance4 instance4 = null;

        static {
            instance4 = new SingleInstance4();
        }

        private SingleInstance4() {

        }

        public static SingleInstance4 getInstance4() {
            return instance4;
        }
    }

    /**
     * 静态内部类单例模式，线程安全
     */
    public static class SingleInstance5 {
        private static final class SingleInstanceHolder {
            private static final SingleInstance5 instance5 = new SingleInstance5();
        }

        private SingleInstance5() {
        }

        public static SingleInstance5 getInstance() {
            return SingleInstanceHolder.instance5;
        }
    }

    /**
     * 枚举类，线程安全
     */
    public enum SingleInstance6 {
        INSTANCE;

        public void whateverMethod() {

        }
    }

    /**
     * 双重校验锁
     */
    public static class SingleInstance7 {
        private static volatile SingleInstance7 instance7 = null;

        private SingleInstance7() {
        }

        public static SingleInstance7 getInstance7() {
            if (instance7 == null) {
                synchronized (SingleInstance7.class) {
                    if (instance7 == null) {
                        instance7 = new SingleInstance7();
                    }
                }
            }
            return instance7;
        }
    }

    /**
     * CAS线程安全
     */
    public static class SingleInstance8 {
        private static final AtomicReference<SingleInstance8> instance = new AtomicReference<>();

        private SingleInstance8() {
        }

        public static SingleInstance8 getInstance8() {
            for (; ; ) {
                SingleInstance8 singleInstance8 = instance.get();
                if (singleInstance8 != null) {
                    return singleInstance8;
                }
                singleInstance8 = new SingleInstance8();
                if (instance.compareAndSet(null, singleInstance8)) {
                    return singleInstance8;
                }
            }
        }
    }

}
