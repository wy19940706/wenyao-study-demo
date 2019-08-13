package com.wenyao.wenyaostudydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.wenyao.concurrentdemo.concurrentsimulate.CountDownLatchUtil;
import com.wenyao.concurrentdemo.concurrentsimulate.HelloService;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.wenyao.concurrentdemo.concurrentsimulate")
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void sayHello() throws Exception {
        long currentTime = System.currentTimeMillis();
        CountDownLatchUtil countDownLatchUtil = new CountDownLatchUtil();
        countDownLatchUtil.latch(() -> helloService.sayHello(currentTime));
    }

}
