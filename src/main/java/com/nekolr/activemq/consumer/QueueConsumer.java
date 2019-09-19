package com.nekolr.activemq.consumer;

/**
 * 队列消费者，只能同步接收消息
 */
public interface QueueConsumer {

    void receive(String destination);

}
