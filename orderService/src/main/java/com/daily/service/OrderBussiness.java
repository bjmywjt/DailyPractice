package com.daily.service;

import com.daily.mapper.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 订单处理监听类
 *
 * @author wangjiangtao
 * @date 2017/12/29
 **/
@Service
public class OrderBussiness {

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.queueName}")
    private String binding;

    Logger logger = LoggerFactory.getLogger(OrderBussiness.class);

    @Autowired
    private RabbitSender sender;
    @Autowired
    private AccountMapper accountMapper;

    @RabbitListener(queues = "topic.order")
    public void receiveMsg(String msg){
        logger.info("接受到的消息:{}。", msg);
        String result = accountMapper.getOrderInfo();
        logger.info("处理完成发送消息:{}。", result);
        sender.sendRabbitMsg(exchange, binding, result);
    }
}
