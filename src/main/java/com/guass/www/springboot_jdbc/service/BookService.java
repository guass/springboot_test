package com.guass.www.springboot_jdbc.service;

import com.guass.www.springboot_jdbc.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "book")
    public void receiveBook(Book book){
        System.out.println("" + book);
    }
}
