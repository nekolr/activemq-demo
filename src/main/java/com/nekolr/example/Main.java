package com.nekolr.example;

import com.nekolr.activemq.producer.QueueProducer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nekolr
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        QueueProducer producer = (QueueProducer) context.getBean("defaultQueueProducer");
        producer.sendMessage("org.apache.activemq.test.defaultQueue", "test");
    }
}
