package com.guass.www.springboot_jdbc.bean;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "book_index",type = "books")
public class Book {

    private Integer id;
    private String name;
    private String auth;
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", auth='" + auth + '\'' +
                ", price=" + price +
                '}';
    }
}
