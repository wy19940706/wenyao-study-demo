package com.wenyao.concurrentdemo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Think on 2019/4/29
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private static final Integer MAX_NODE_NUM = 100;
    private Integer limit;

    public LRUCache() {
        super(MAX_NODE_NUM);
    }

    public LRUCache(int limit) {
        super(limit, 0.75f, true);
        this.limit = limit;
    }

    public V save(K key, V value) {
        return put(key, value);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > limit;
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> lruCache = new LRUCache<>(3);
        for (int i = 0; i < 10; i++) {
            lruCache.save(i, i * i);
        }

        System.out.println("插入10个键值对后，缓存内容：");
        System.out.println(lruCache + "\n");

        System.out.println("访问键值为7的节点后，缓存内容：");
        lruCache.get(7);
        System.out.println(lruCache + "\n");

        System.out.println("插入键值为1的节点后，缓存内容：");
        lruCache.save(1, 1);
        System.out.println(lruCache + "\n");
    }
}
