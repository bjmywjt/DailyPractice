package com.daily.javaconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 配置
 * @author wangjiangtao
 * @date 2017/12/29
 **/
@Configuration
public class TopicConf implements EnvironmentAware{

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        propertyResolver = new RelaxedPropertyResolver(env, "spring.rabbitmq.");
    }

    @Bean("message")
    public Queue queueMessage(){
        return new Queue(propertyResolver.getProperty("queueName"));
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(propertyResolver.getProperty("exchange"));
    }

    @Bean
    public Binding bindingMsgToExchange(@Qualifier("message") Queue queue, TopicExchange topicExchange ){
        return BindingBuilder.bind(queue).to(topicExchange).with(propertyResolver.getProperty("routingKey"));
    }

}
