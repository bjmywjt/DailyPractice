package com.daily.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * rabbit消息发送机
 *
 * @author wangjiangtao
 * @date 2017/12/29
 **/
@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate template;

    public void sendRabbitMsg(String exchange, String routingKey, String msg){
        template.convertAndSend(exchange, routingKey, msg);
    }
}
