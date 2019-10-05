package com.wenyao.streamdemo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by Think on 2019/1/11
 */
public class StreamTestDemo {

    public static void main(String[] args) {
        Integer result = functionTest(3, e -> e * 3);
        System.out.println(result);
        consumerTest(2, e -> System.out.println(e * 2));
        String str = "3";
        System.out.println(predicateTest(str, e -> "2".equals(e)));
        System.out.println(supplierTest(() -> str.length()));
    }

    private static <T, R> R functionTest(T value, Function<T, R> function) {
        return function.apply(value);
    }

    private static <T> void consumerTest(T value, Consumer<T> consumer) {
        consumer.accept(value);
    }

    private static <T> boolean predicateTest(T value, Predicate<T> predicate) {
        return predicate.test(value);
    }

    private static <T> T supplierTest(Supplier<T> supplier) {
        return supplier.get();
    }

    public static <T, R> List<R> map(List<T> data, Function<T, R> mapFunction) {
        return data.stream().map(mapFunction).collect(Collectors.toList());

    }

}
