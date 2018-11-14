package com.guass.www.springboot_jdbc.service;

import com.guass.www.springboot_jdbc.bean.Department;
import com.guass.www.springboot_jdbc.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper mDepartmentMapper;



    @Cacheable(cacheNames = "dept")
    public Department getDepartment(Integer id){
        return mDepartmentMapper.getDeptById(id);
    }


    public Department insertDept(Department department){
        mDepartmentMapper.insertDept(department);
        return department;
    }
}
