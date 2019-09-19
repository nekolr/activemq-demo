package com.nekolr.activemq.producer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author nekolr
 */
@Component
public class AbstractTopicProducer implements TopicProducer {

    @Resource(name = "jmsTopicTemplate")
    private JmsTemplate jmsTopicTemplate;

    @Override
    public void publishMessage(String destination, Object message) {
        this.doPublish(destination, message);
    }

    @Override
    public void publishMessage(String destination, String message) {
        this.doPublish(destination, message);
    }

    protected void doPublish(String destination, Object message) {
        jmsTopicTemplate.send(destination, session -> jmsTopicTemplate.getMessageConverter().toMessage(message, session));
    }

    protected void doPublish(String destination, String message) {
        jmsTopicTemplate.send(destination, session -> session.createTextMessage(message));
    }

}
