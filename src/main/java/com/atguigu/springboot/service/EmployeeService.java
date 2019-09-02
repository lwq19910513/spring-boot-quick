package com.atguigu.springboot.service;

import com.atguigu.springboot.entities.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @CachePut(value = "emp", key = "#result.id")
    public Employee saveEmp(Employee employee) {
        employeeMapper.insertEmp(employee);
        return employee;
    }

    @Cacheable(cacheNames = "emp")
    public Employee getEmpById(Integer id) {
        System.out.println("=====查询员工=====");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    @CachePut(value = "emp", key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("update emp:" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("deleteEmp:" + id);
//        employeeMapper.deleteEmpById(id);
    }

    @Cacheable(value = "emp")
    public List<Employee> getAll() {
        List<Employee> employees = employeeMapper.getEmps();
        System.out.println(employees);
        return employees;
    }
}
