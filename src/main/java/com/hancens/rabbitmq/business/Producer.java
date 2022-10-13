package com.hancens.rabbitmq.business;

import com.hancens.rabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class Producer {

    @Autowired
    private  RabbitTemplate rabbitTemplate;



    public void produce()  {
        String message = "疫情期间注意防护";
        log.info("当前时间：{}，发送一条消息给队列：{}",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) ,message);
        rabbitTemplate.convertAndSend("delayed_exchange","routinkey",message,ms->{
            ms.getMessageProperties().setDelay(10000);
            return ms;
        });


    }
}