package com.wenyao.streamdemo;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.google.common.collect.Sets;

public class FunctionTest {

    private static Set<String> beanNameSet = Sets.newHashSet("wenyao", "alibaba");
    private static Set<String> singletonObjectSet = Sets.newHashSet("wenyao", "alibaba");

    public static void main(String[] args) {
        registerSingleton("wenyao", "alibaba");
        System.out.println(beanNameSet);
        System.out.println(singletonObjectSet);
    }


    public static void registerSingleton(String beanName, Object singletonObject) throws IllegalStateException {
        test(e -> e.remove(beanName), e -> e.contains(singletonObject));
    }

    private static void test(Consumer<Set<String>> consumer, Predicate<Set<String>> predicate) {
        if (predicate.test(singletonObjectSet)) {
            consumer.accept(beanNameSet);
        }
    }
}
