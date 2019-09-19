package com.nekolr.activemq.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author nekolr
 */
@Component
public class DefaultTopicProducer implements TopicProducer {

    @Resource(name = "jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;

    @Override
    public void publishMessage(String destination, Object message) {
        jmsTopicTemplate.send(destination, session -> jmsTopicTemplate.getMessageConverter().toMessage(message, session));
    }

    @Override
    public void publishMessage(String destination, String message) {
        jmsTopicTemplate.send(destination, session -> session.createTextMessage(message));
    }
}
