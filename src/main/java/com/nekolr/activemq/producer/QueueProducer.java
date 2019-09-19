package com.nekolr.activemq.producer;

/**
 * 队列生产者
 *
 * @author nekolr
 */
public interface QueueProducer {

    void sendMessage(String destination, final Object message);

    void sendMessage(String destination, final String message);
}
