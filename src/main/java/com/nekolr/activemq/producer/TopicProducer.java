package com.nekolr.activemq.producer;

/**
 * Topic 生产者
 *
 * @author nekolr
 */
public interface TopicProducer {

    void publishMessage(String destination, Object message);

    void publishMessage(String destination, String message);
}
