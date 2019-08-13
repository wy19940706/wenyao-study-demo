package com.wenyao.wenyaostudydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = "com.wenyao.concurrentdemo.concurrentsimulate")
public class WenyaoStudyDemoApplicationTests implements CommandLineRunner {

    @Test
    public void contextLoads() {}

    @Override
    public void run(String... args) throws Exception {

    }
}
