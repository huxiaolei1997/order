package com.imooc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 接收 mq 消息
 * @author xiaolei hu
 * @date 2018/10/7 19:19
 **/
@Slf4j
@Component
public class MqReceiver {

//    @RabbitListener(queues = "myQueue")
//    // 自动声明队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 自动声明并绑定交换机
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }

    /**
     * 数码供应商 接收消息
     * @param message
     */

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("computerOrder"),
            key = "computer",
            exchange = @Exchange("myOrder")
    ))
    public void processComputer(String message) {
        log.info("MqReceiver: {}", message);
    }

    /**
     * 水果供应商 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fruitOrder"),
            key = "fruit",
            exchange = @Exchange("myOrder")
    ))
    public void processFruit(String message) {
        log.info("MqReceiver: {}", message);
    }
}
