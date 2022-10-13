package com.hancens.rabbitmq;

import com.hancens.rabbitmq.business.Producer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    Producer producer;

    @Test
    void contextLoads() throws UnsupportedEncodingException {
        // 生产者发送消息
        producer.produce();
    }

}
