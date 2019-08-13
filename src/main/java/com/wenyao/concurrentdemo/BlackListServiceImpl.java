package com.wenyao.concurrentdemo;

import java.util.Map;

/**
 * Created by Think on 2019/5/9
 */
public class BlackListServiceImpl {

    private static CopyOnWriteMap<String, Boolean> blackListMap = new CopyOnWriteMap<>();

    public static Boolean isBlackList(String id) {
        return blackListMap.get(id) == null ? Boolean.FALSE : Boolean.TRUE;
    }

    public static void addBlackList(String id) {
        blackListMap.put(id, Boolean.TRUE);
    }

    public static void addBlackList(Map<String, Boolean> ids) {
        blackListMap.putAll(ids);
    }
}
