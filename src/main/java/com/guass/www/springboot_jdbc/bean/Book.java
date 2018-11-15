package com.guass.www.springboot_jdbc.bean;

public class Book {

    private String name;
    private String auth;
    private Float price;

    public Book() {
    }

    public Book(String name, String auth, Float price) {
        this.name = name;
        this.auth = auth;
        this.price = price;
    }
}
