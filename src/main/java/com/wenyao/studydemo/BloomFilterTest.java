package com.wenyao.studydemo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by Think on 2019/5/19
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);
        for (int i = 0; i < 10000000; i++) {
            bloomFilter.put(i);
        }

        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(2));
        System.out.println(bloomFilter.mightContain(3));
        System.out.println(bloomFilter.mightContain(10000000));
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start));
    }
}
