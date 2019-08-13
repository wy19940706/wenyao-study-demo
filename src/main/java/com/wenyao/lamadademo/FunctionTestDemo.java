package com.wenyao.lamadademo;

import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Think on 2019/4/4
 */
public class FunctionTestDemo {
    public static void main(String[] args) {
        int result1 = compose(3, value -> value * value);
        int result2 = compose(5, value -> value + value);
        int result3 = composeTwo(3, value -> value + value, v -> v * v);
        int result4 = andThen(3, v -> v + v, v -> v * v);
        int result5 = composeThree(2, 3, (value1, value2) -> value1 * value2);
        int result6 = andThenTwo(2, 3, (value1, value2) -> value1 + value2, value -> value * value);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(removeIf(v -> v == 6, Lists.newArrayList(1, 2, 3)));
    }

    private static int compose(int n, Function<Integer, Integer> function) {
        return function.apply(n);
    }

    private static int composeTwo(int n, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(n);
    }

    private static int andThen(int n, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(n);
    }

    private static int composeThree(int m, int n, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(m, n);
    }

    private static int andThenTwo(int m, int n, BiFunction<Integer, Integer, Integer> biFunction1, Function<Integer, Integer> function) {
        return biFunction1.andThen(function).apply(m, n);
    }

    private static <E> boolean removeIf(Predicate<? super E> filter, Collection<E> collection) {
        Objects.requireNonNull(filter);
        boolean result = false;
        for (Iterator<E> it = collection.iterator(); it.hasNext(); ) {
            if (filter.test(it.next())) {
                it.remove();
                result = true;
            }
        }
        return result;
    }

}
