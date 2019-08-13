package com.wenyao.concurrentdemo.concurrentsimulate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public void sayHello(long timeMillis) {
        long time = System.currentTimeMillis() - timeMillis;
        if (time > 5000) {
            // 超过5s的打印日志输出
            LOGGER.warn("time:{}", time);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
