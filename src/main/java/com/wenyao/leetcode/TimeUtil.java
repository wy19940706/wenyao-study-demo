package com.wenyao.leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Supplier;

/**
 * 计算方法的执行时间
 */
public class TimeUtil {
    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task {
        void execute();
    }

    public static void calculateTime(String title, Task task) {
        if (task == null) {
            return;
        }
        title = (title == null) ? "" : ("【" + title + "】");
        System.out.println(title);
        System.out.println("开始：" + fmt.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束：" + fmt.format(new Date()));
        double delta = (end - begin) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("-------------------------------------");
    }

    public static void calculate(String methodName, Supplier supplier) {
        System.out.println("方法名：" + methodName);
        long startTime = System.currentTimeMillis();
        supplier.get();
        long endTime = System.currentTimeMillis();
        double delta = (endTime - startTime) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
    }
}

