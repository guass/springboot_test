package com.guass.www.springboot_jdbc.repository;

import com.guass.www.springboot_jdbc.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
