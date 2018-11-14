package com.guass.www.springboot_jdbc.service;

import com.guass.www.springboot_jdbc.bean.Employee;
import com.guass.www.springboot_jdbc.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeService {

    @Autowired
    EmployeeMapper mEmployeeMapper;

    @Cacheable
    public Employee getEmp(@PathVariable("id") Integer id){
        System.out.println("guass getEmp" );
        return mEmployeeMapper.getEmpById(id);
    }

    public Employee insertEmp(String name){

        Employee employee =new Employee();
        employee.setdId(2);
        employee.setEmail(name +"@gmail.com");
        employee.setGender(0);
        employee.setLastName(name);

        mEmployeeMapper.insertEmp(employee);

        return employee;
    }


    @Caching(
            cacheable = {@Cacheable(key = "#name")},
            put = {
                    @CachePut(key = "#result.id"),
                    @CachePut(key = "#result.email"),
            }
    )
    public Employee getEmpByName(String name){
        return mEmployeeMapper.getEmpByName(name);
    }
}
