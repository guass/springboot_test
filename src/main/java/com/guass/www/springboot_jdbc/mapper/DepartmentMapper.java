package com.guass.www.springboot_jdbc.mapper;

import com.guass.www.springboot_jdbc.bean.Department;
import org.apache.ibatis.annotations.*;

public interface DepartmentMapper {

  //  @Select("select * from department where id=#{id}")
    Department getDeptById(Integer id);


    int deleteDept(Integer id);

//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Department department);

//    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    int updateDept(Department department);
}
