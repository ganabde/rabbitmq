package com.hancens.rabbitmq.business;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class Consumer {

    @RabbitListener(queues = "delayed_queue")
    public void receiveD(String message){
        log.info("当前时间{}，收到队列的消息：{}", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()),message);
    }



}
