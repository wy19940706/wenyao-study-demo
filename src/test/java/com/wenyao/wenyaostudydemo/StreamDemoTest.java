package com.wenyao.wenyaostudydemo;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamDemoTest extends BaseTest {

    @Test
    public void test1(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        int minGroup = Integer.parseInt(args[1]);
        try (Stream<String> words = Files.lines(path)) {
            words.collect(Collectors.groupingBy(word -> method(word)))
                    .values()
                    .stream()
                    .filter(e -> e.size() >= minGroup)
                    .forEach(e1 -> System.out.println(e1.size() + ":" + e1));
        }
    }

    private static String method(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.ONE, BigInteger::nextProbablePrime);
    }

    @Test
    public void test2() {
    }

}
