package com.nekolr.example;

import com.nekolr.activemq.producer.QueueProducer;
import com.nekolr.example.entity.EmailEntity;
import com.nekolr.example.entity.SmsEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nekolr
 */
public class Main {

    public static void sendEmail() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        QueueProducer producer = (QueueProducer) context.getBean("defaultQueueProducer");

        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setReceiveEmail("example@gmail.com");
        emailEntity.setSendEmail("saber@gmail.com");
        emailEntity.setSendAccount("saber");
        emailEntity.setSendPassword("saber");
        emailEntity.setBody("Hello World.");

        producer.sendMessage("org.apache.activemq.test.defaultQueue", emailEntity);
    }

    public static void sendSms() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        QueueProducer producer = (QueueProducer) context.getBean("defaultQueueProducer");

        SmsEntity smsEntity = new SmsEntity();
        smsEntity.setReceiveMobile("12345678900");
        smsEntity.setSendMobile("12345678909");
        smsEntity.setBody("Hello World.");

        producer.sendMessage("org.apache.activemq.test.defaultQueue", smsEntity);
    }

    public static void main(String[] args) {
        sendSms();
    }
}
