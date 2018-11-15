package com.guass.www.springboot_jdbc;

import com.guass.www.springboot_jdbc.bean.Article;
import com.guass.www.springboot_jdbc.bean.Book;
import com.guass.www.springboot_jdbc.bean.Employee;
import com.guass.www.springboot_jdbc.mapper.EmployeeMapper;
import com.guass.www.springboot_jdbc.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJdbcApplicationTests {

//    @Autowired
//    DataSource mDataSource;

    @Autowired
    StringRedisTemplate mRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    EmployeeMapper mEmployeeMapper;

    @Autowired
    RabbitTemplate mRabbitTemplate;


    @Autowired
    AmqpAdmin mAmqpAdmin;

    @Autowired
    JestClient mJestClient;

    @Autowired
    BookRepository mBookRepository;

    @Test
    public void creatEx(){
//        mAmqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        mAmqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));

        mAmqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.guass",null));
    }

//    @Autowired
//    RedisTemplate<Object, Employee> mObjectEmployeeRedisTemplate;

    @Test
    public void contextLoads() {
     //   try {
//            System.out.println("guass " + mDataSource.getClass());

     //   mRedisTemplate.opsForValue().append("msg","hello")

//        System.out.println(" guass " + mRedisTemplate.opsForValue().get("msg"));

//       redisTemplate.opsForValue().set("emp-01",mEmployeeMapper.getEmpById(2));

 //       mObjectEmployeeRedisTemplate.opsForValue().set("emp01",mEmployeeMapper.getEmpById(2));

//        Book book = new Book();
//        book.setAuth("guass");
//        book.setName("android");
//        book.setPrice(19.5f);
//        mRabbitTemplate.convertAndSend("guass.fanout",book);



    }


    @Test
    public void esAdd(){
        Article article = new Article();

        article.setId(1);
        article.setTitle("title");
        article.setAuthor("guass");
        article.setContent("content content ~~~~~~~~~~~~~~~~");

        Index index = new Index.Builder(article).index("guass_index").type("news").build();

        try {
            mJestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void esSearch(){
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"content\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search build = new Search.Builder(json).addIndex("guass_index").addType("news").build();

        try {
            SearchResult execute = mJestClient.execute(build);
          //  execute.getJsonString();

            System.out.println(" execute " +execute.getJsonString() );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void receiver(){
        Object o = mRabbitTemplate.receiveAndConvert("guass.news");

        System.out.println("msg get " + o);

    }

}
