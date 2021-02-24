package com.wenyao.chainmode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wenyao
 * @Description 异常处理测试类
 * @Date 2020/7/8 10:19 上午
 */
@Slf4j
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            test1();
            System.out.println("哈哈哈哈我被执行了");
        } catch (Exception e) {
            log.error("main exception:{}", e.getMessage(), e);
        }
    }

    private static void test1() {
        // try {
        test2();
        // } catch (Exception e) {
        // log.error("test1 exception:{}", e.getMessage(), e);
        // }
    }

    private static void test2() {
        try {
            int temp = 1 / 0;
        } catch (Exception e) {
            log.error("test2 exception:{}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }


}
