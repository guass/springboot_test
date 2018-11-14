package com.guass.www.springboot_jdbc;

import com.guass.www.springboot_jdbc.bean.Employee;
import com.guass.www.springboot_jdbc.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJdbcApplicationTests {

    @Autowired
    DataSource mDataSource;

    @Autowired
    StringRedisTemplate mRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    EmployeeMapper mEmployeeMapper;

    @Autowired
    RedisTemplate<Object, Employee> mObjectEmployeeRedisTemplate;

    @Test
    public void contextLoads() {
     //   try {
//            System.out.println("guass " + mDataSource.getClass());

     //   mRedisTemplate.opsForValue().append("msg","hello")

//        System.out.println(" guass " + mRedisTemplate.opsForValue().get("msg"));

//       redisTemplate.opsForValue().set("emp-01",mEmployeeMapper.getEmpById(2));

        mObjectEmployeeRedisTemplate.opsForValue().set("emp01",mEmployeeMapper.getEmpById(2));

    }

}
