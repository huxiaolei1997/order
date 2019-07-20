package com.imooc.order.message;

import com.imooc.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public String processInput(Message<OrderDTO> message) {
        log.info("input : {}", message.getPayload());
        // 接收到消息之后又重新发送订单ID到 OUTPUT 这个队列
        return message.getPayload().getOrderId();
    }

    @StreamListener(StreamClient.OUTPUT)
    public void processOutput(Message<String> message) {
        //System.out.println(message.toString());
        log.info("output: {}", message.getPayload());
    }


}
