package com.wenyao.wenyaostudydemo;

import com.deepoove.swagger.dubbo.annotations.EnableDubboSwagger;
import com.wenyao.aopdemo.Test;
import com.wenyao.concurrentdemo.concurrentsimulate.HelloService;
import com.wenyao.studydemo.annotation.TestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@EnableDubboSwagger
@ComponentScan(basePackages = "com.wenyao")
public class WenyaoStudyDemoApplication implements CommandLineRunner {

    @Resource
    private HelloService helloService;
    @Resource
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(WenyaoStudyDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        helloService.sayHello(4000);
        testService.test();
    }
}
