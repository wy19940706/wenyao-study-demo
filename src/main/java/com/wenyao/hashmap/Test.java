package com.wenyao.hashmap;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Collection<Integer> disjunction =
                CollectionUtil.disjunction(Lists.newArrayList(1, 2), Lists.newArrayList(1, 3));
        System.out.println(disjunction);
    }

}
