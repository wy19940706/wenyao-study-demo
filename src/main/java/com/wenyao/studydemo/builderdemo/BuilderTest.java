package com.wenyao.studydemo.builderdemo;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Think on 2019/4/8
 */
public class BuilderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        User user = User.newBuilder().name("wenyao").age(25).length(178).build();
        System.out.println(JSON.toJSONString(user));

        Method[] methods = User.class.getDeclaredMethods();
        System.out.println(methods);
        Field[] fields = User.class.getDeclaredFields();
        System.out.println(fields);

        Class<?> cls = Class.forName("com.wenyao.studydemo.builderdemo.User");
        Constructor<?> constructor = cls.getConstructor(String.class, int.class, int.class);
        Object o = constructor.newInstance("wenyao", 12, 12);
        System.out.println(JSON.toJSONString(o));
        Method method = cls.getDeclaredMethod("toString");
        method.invoke(user, null);
        Field field = cls.getDeclaredField("name");
        field.setAccessible(true);
        field.set(user, "hahahaha");
        System.out.println(field.get(user));
    }
}
