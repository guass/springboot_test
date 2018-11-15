//package com.guass.www.springboot_jdbc.service;
//
//import com.guass.www.springboot_jdbc.bean.Book;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BookService {
//
////    @RabbitListener(queues = "book")
////    public void receiveBook(Book book){
////        System.out.println("" + book);
////    }
//
//    @RabbitListener(queues = "book")
//    public void receiveBook(Message message){
//        System.out.println("guass message " + message.getBody().toString());
//        System.out.println("guass message ");
//    }
//}
