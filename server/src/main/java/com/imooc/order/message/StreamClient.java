package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface StreamClient {
    String INPUT = "myMessage";

    String OUTPUT = "myMessage2";

    @Input(StreamClient.INPUT)
    SubscribableChannel input1();

    @Output(StreamClient.OUTPUT)
    MessageChannel output1();
}
