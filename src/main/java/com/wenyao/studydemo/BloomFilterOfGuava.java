package com.wenyao.studydemo;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * guava实现的布隆过滤器
 */
public class BloomFilterOfGuava {

    private static final Integer total = 1000000;
    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), total, 0.001);

    public static void main(String[] args) {

        // 先把数据全部放进去
        for (int i = 0; i < total; i++) {
            bloomFilter.put(i);
        }

        for (int i = 0; i < total; i++) {
            if (!bloomFilter.mightContain(i)) {
                System.out.println("有元素逃脱了，没有在过滤器中");
            }
        }

        int count = 0;
        for (int i = total; i < total + 10000; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误判的数量：" + count);
    }

}
