package com.nekolr.example.consumer;

import com.nekolr.activemq.consumer.QueueConsumer;
import com.nekolr.example.entity.SmsEntity;
import com.nekolr.example.util.SmsUtils;

/**
 * 通过 MessageListenerAdapter 反射调用 SmsQueueConsumer 的 receive 方法
 *
 * @author nekolr
 */
public class SmsQueueConsumer implements QueueConsumer {
    @Override
    public void receive(Object message) {
        SmsEntity smsEntity = (SmsEntity) message;
        if (smsEntity != null) {
            SmsUtils.sendSms(smsEntity);
        }
    }
}
