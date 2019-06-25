//package com.imooc.order.controller;
//
//
//import com.imooc.order.dto.OrderDTO;
//import com.imooc.order.message.StreamClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.jaxb.SpringDataJaxb;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
//@RestController
//public class SendMessageController {
//    @Autowired
//    private StreamClient streamClient;
//
////    @GetMapping("/sendMessage")
////    public void process() {
////        String message = "测试";
////        OrderDTO orderDTO = new OrderDTO();
////        orderDTO.setOrderId("123456");
////        streamClient.input1().send(MessageBuilder.withPayload(message).build());
////    }
//
//    @GetMapping("/sendMessage")
//    public void process() {
//        //String message = "测试";
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setOrderId("123456");
//        streamClient.input1().send(MessageBuilder.withPayload(orderDTO).build());
//    }
//}
