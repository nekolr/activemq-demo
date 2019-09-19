package com.nekolr.activemq.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 使用 MessageListener 可以异步接收消息
 */
public class SendMessageListener implements MessageListener {

    @Autowired
    private MessageConverter messageConverter;

    @Override
    public void onMessage(Message message) {
        try {
            Object msg = messageConverter.fromMessage(message);
            if (msg != null) {
                System.out.println(msg);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
