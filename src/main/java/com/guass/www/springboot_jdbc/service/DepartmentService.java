package com.guass.www.springboot_jdbc.service;

import com.guass.www.springboot_jdbc.bean.Department;
import com.guass.www.springboot_jdbc.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper mDepartmentMapper;

    @Autowired
    RedisCacheManager mRedisCacheManager;


    @Cacheable(cacheNames = "dept",key = "#id")
    public Department getDepartment(Integer id){
        return mDepartmentMapper.getDeptById(id);
    }


    public Department insertDept(Department department){
        mDepartmentMapper.insertDept(department);
        return department;
    }


    public Department getDepartment2(Integer id){


        Department department = null;

        Cache dept = mRedisCacheManager.getCache("dept");

        Cache.ValueWrapper valueWrapper = dept.get("" + id);

        if(valueWrapper != null) {
           department = (Department) valueWrapper.get();
        }

        if(department != null){
            return department;
        }
        else {
            Department deptById = mDepartmentMapper.getDeptById(id);
            dept.put(""+id,deptById);
            return deptById;
        }

    }
}
