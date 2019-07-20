package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


/**
 * 通过 spring-cloud-stream 来发送和接收消息
 */
public interface StreamClient {
    String INPUT = "myMessage";

    String OUTPUT = "myMessage2";

    /**
     * 同一个服务里面的信道名字不能一样，在不同的服务里可以相同名字的信道
     * @return
     */
    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
