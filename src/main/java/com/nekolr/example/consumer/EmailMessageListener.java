package com.nekolr.example.consumer;

import com.nekolr.example.entity.EmailEntity;
import com.nekolr.example.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

public class EmailMessageListener implements MessageListener {
    @Autowired
    private MessageConverter messageConverter;

    @Override
    public void onMessage(Message message) {
        EmailEntity emailEntity;
        try {
            emailEntity = (EmailEntity) messageConverter.fromMessage(message);
            if (emailEntity != null) {
                EmailUtils.sendEmail(emailEntity);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
