package com.hancens.rabbitmq.business;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/ttl")
public class sendMessgeController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg3/{msg}/{now}")
    public void sendMesg3(@PathVariable String msg,@PathVariable int now){
        Date date = new Date();
        log.info("当前时间：{}，发送一条消息给队列：{}",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) ,msg);
        rabbitTemplate.convertAndSend("delayed_exchange","routinkey",msg,ms->{
            ms.getMessageProperties().setDelay(now);
            return ms;
        });
    }
}
