package com.wenyao.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    /**
     * 
     * @param args
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("com.wenyao.reflectdemo.InterfaceFieldTestImpl");
        Object interfaceFieldTest = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("printMsg", Integer.class);
        Object object = method.invoke(interfaceFieldTest, 190);
        System.out.println(object);
        Class clazzTwo = Class.forName("com.wenyao.reflectdemo.User");
        // 获取无参构造函数
        Constructor constructor = clazzTwo.getConstructor();
        // 创建实例
        Object newInstance = constructor.newInstance();
        System.out.println(newInstance);
        // 获取有参构造函数
        Constructor clazzTwoConstructor = clazzTwo.getConstructor(Long.class, String.class);
        Object wenyao = clazzTwoConstructor.newInstance(1L, "wenyao");
        System.out.println(wenyao);
        // 获取public成员变量
        Field[] clazzTwoFields = clazzTwo.getFields();
        for (Field field : clazzTwoFields) {
            System.out.println(field);
        }
        // 获取所有已声明成员变量
        Field[] declaredFields = clazzTwo.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        // 获取所有public方法
        Method[] methods = clazzTwo.getMethods();
        for (Method method1 : methods) {
            System.out.println(method1);
        }
        // 获取所有已声明方法
        Method[] declaredMethods = clazzTwo.getDeclaredMethods();
        for (Method method2 : declaredMethods) {
            System.out.println(method2);
        }
        // 设置值
        Method setName = clazzTwo.getDeclaredMethod("setName", String.class);
        setName.invoke(newInstance, "温尧");
        Method getName = clazzTwo.getDeclaredMethod("getName");
        Object result = getName.invoke(newInstance);
        System.out.println(result);
        Object newInstanceByClass = clazzTwo.newInstance();
        Method setNameTwo = clazzTwo.getDeclaredMethod("setName", String.class);
        setNameTwo.invoke(newInstanceByClass, "温尧");
        Method getNameTwo = clazzTwo.getDeclaredMethod("getName");
        Object resultTwo = getNameTwo.invoke(newInstanceByClass);
        System.out.println(resultTwo);
    }

}
