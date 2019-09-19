package com.nekolr.example;

import com.nekolr.activemq.producer.QueueProducer;
import com.nekolr.example.entity.EmailEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nekolr
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        QueueProducer producer = (QueueProducer) context.getBean("emailQueueProducer");

        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setReceiveEmail("example@gmail.com");
        emailEntity.setSendEmail("saber@gmail.com");
        emailEntity.setSendAccount("saber");
        emailEntity.setSendPassword("saber");
        emailEntity.setBody("Hello World.");

        producer.sendMessage("org.apache.activemq.test.defaultQueue", emailEntity);
    }
}
