package com.guass.www.springboot_jdbc.controller;



import com.guass.www.springboot_jdbc.bean.Employee;

import com.guass.www.springboot_jdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {


    @Autowired
    EmployeeService mEmployeeService;

//
//    @GetMapping("/dept/{id}")
//    public Department getDepartment(@PathVariable("id") Integer id){
//        return departmentMapper.getDeptById(id);
//    }
//
//    @GetMapping("/dept")
//    public Department insertDept(Department department){
//      //  departmentMapper.insertDept(department);
//        return department;
//    }


}
