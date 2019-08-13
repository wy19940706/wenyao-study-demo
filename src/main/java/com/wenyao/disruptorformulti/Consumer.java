package com.wenyao.disruptorformulti;

import com.lmax.disruptor.WorkHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 消费者
 */
public class Consumer implements WorkHandler<Order> {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private String consumerId;
    private static AtomicInteger count = new AtomicInteger(0);

    public Consumer(String consumerId) {
        this.consumerId = consumerId;
    }

    /**
     * 消费事件
     * 
     * @param order
     * @throws Exception
     */
    @Override
    public void onEvent(Order order) throws Exception {
        logger.info("当前消费者[{}]，消费信息：{}", this.consumerId, order.getOrderId());
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
