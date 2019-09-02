package com.atguigu.springboot.mapper;

import com.atguigu.springboot.entities.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into employee(last_name, email, gender, d_id, birth) values(#{lastName}, #{email}, #{gender}, #{dId}, #{birth})")
    public void insertEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmpById(Integer id);

    @Update("update employee set last_name=#{lastName},email=#{email},gender=#{gender},d_id=#{dId},birth=#{birth} where id=#{id}")
    public void updateEmp(Employee employee);

    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Select("select * from employee")
    @Results({
            @Result(column = "d_id", property = "department",
                one = @One(select = "com.atguigu.springboot.mapper.DepartmentMapper.getDepById",
                        fetchType = FetchType.EAGER))
    })
    public List<Employee> getEmps();
}
