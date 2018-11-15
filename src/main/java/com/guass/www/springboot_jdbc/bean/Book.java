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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
