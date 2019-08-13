package com.wenyao.studydemo;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> (a + b)));
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(e -> e < 3));
        System.out.println(map);
        Predicate<Integer> predicate = x -> x > 185;
        System.out.println(predicate.test(199));
        Consumer<String> consumer = System.out::println;
        consumer.accept("我是消费者");
        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        System.out.println(supplier.get());
        Function<Integer, String> function = e -> String.valueOf(e);
        System.out.println(function.apply(5));
        UnaryOperator<Boolean> unaryOperator = ugly -> !ugly;
        System.out.println(unaryOperator.apply(true));
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperator.apply(4, 5));
    }
}
