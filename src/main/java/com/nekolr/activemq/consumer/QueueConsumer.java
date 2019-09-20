package com.nekolr.activemq.consumer;

/**
 * 队列消费者
 */
public interface QueueConsumer {

    void receive(Object message);

}
