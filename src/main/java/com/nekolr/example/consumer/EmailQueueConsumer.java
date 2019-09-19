package com.nekolr.example.consumer;

import com.nekolr.activemq.consumer.QueueConsumer;
import com.nekolr.example.entity.EmailEntity;
import com.nekolr.example.util.EmailUtils;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 主动消费，使用 JmsTemplate 只能同步接收消息，异步接收消息需要使用消息监听
 */
@Component
public class EmailQueueConsumer implements QueueConsumer {

    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsQueueTemplate;

    @Override
    public void receive(String destination) {
        EmailEntity emailEntity = (EmailEntity) jmsQueueTemplate.receiveAndConvert(destination);
        if (emailEntity != null) {
            EmailUtils.sendEmail(emailEntity);
        }
    }
}
