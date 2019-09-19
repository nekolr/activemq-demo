package com.nekolr.activemq.consumer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * JmsTemplate 只能同步接收消息
 */
@Component
public class DefaultQueueConsumer implements QueueConsumer {

    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    @Override
    public void receive(String destination) {
        Object message = jmsQueueTemplate.receiveAndConvert(destination);
        if (message != null) {
            System.out.println(message);
        }
    }
}
