package com.guass.www.springboot_jdbc.controller;


import com.guass.www.springboot_jdbc.bean.Employee;
import com.guass.www.springboot_jdbc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {


    @Autowired
    EmployeeService mEmployeeService;



    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
       return mEmployeeService.getEmp(id);
    }


    @GetMapping("/insertEmp/{name}")
    public Employee insertEmp(@PathVariable("name") String name){



        return mEmployeeService.insertEmp(name);
    }

    @GetMapping("/getEmp/{name}")
    public Employee getEmpByName(@PathVariable("name") String name){
        return mEmployeeService.getEmpByName(name);
    }

}
