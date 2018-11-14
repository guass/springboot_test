package com.guass.www.springboot_jdbc.mapper;

import com.guass.www.springboot_jdbc.bean.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

    Employee getEmpById(@Param("id") Integer id);

    void insertEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmp(@Param("id") Integer id);


    Employee getEmpByName(@Param("name") String name);
}
