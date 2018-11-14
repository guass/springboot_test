package com.guass.www.springboot_jdbc.controller;



import com.guass.www.springboot_jdbc.bean.Department;
import com.guass.www.springboot_jdbc.bean.Employee;

import com.guass.www.springboot_jdbc.mapper.DepartmentMapper;
import com.guass.www.springboot_jdbc.service.DepartmentService;
import com.guass.www.springboot_jdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {


    @Autowired
    DepartmentService mDepartmentService;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return mDepartmentService.getDepartment2(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        mDepartmentService.insertDept(department);
        return department;
    }


}
