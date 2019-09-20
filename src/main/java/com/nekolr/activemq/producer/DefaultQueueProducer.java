package com.nekolr.activemq.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author nekolr
 */
@Component
public class DefaultQueueProducer implements QueueProducer {

    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    @Override
    public void sendMessage(String destination, Object message) {
        this.doSend(destination, message);
    }

    @Override
    public void sendMessage(String destination, String message) {
        this.doSend(destination, message);
    }

    protected void doSend(String destination, String message) {
        jmsQueueTemplate.send(destination, session -> session.createTextMessage(message));
    }

    protected void doSend(String destination, Object message) {
        jmsQueueTemplate.send(destination, session -> jmsQueueTemplate.getMessageConverter().toMessage(message, session));
    }

}
