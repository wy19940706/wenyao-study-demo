package com.wenyao.functiondemo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Think on 2019/1/22
 */
public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer, Integer> param1 = e -> e * 2;
        Function<Integer, Integer> param2 = e -> e * e;
        int value1 = param1.andThen(param2).apply(3);
        System.out.println("andThen value1 = " + value1);
        int value2 = param1.compose(param2).apply(3);
        System.out.println("compose value2 = " + value2);
        Object identity = Function.identity().apply("wenyao");
        System.out.println(identity);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.stream().filter(num -> num != 2).collect(Collectors.toList());
    }
}
