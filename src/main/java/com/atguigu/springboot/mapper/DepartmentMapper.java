package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDepById(Integer id);
}