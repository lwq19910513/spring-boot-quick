package com.atguigu.springboot.controller;

import com.atguigu.springboot.entities.Employee;
import com.atguigu.springboot.exception.UserNotExistException;
import com.atguigu.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloWorld {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/hello/saveemp")
    public Employee saveEmp(Employee employee) {
        Employee emp = employeeService.saveEmp(employee);
        return emp;
    }

    @GetMapping("/hello/{id}")
    public Employee hello(@PathVariable("id") Integer id) {
//        if("aaa".equals(user)) {
//            throw new UserNotExistException();
//        }
        Employee employee = employeeService.getEmpById(id);
        System.out.println(employee);
        return employee;
    }

    @GetMapping("/hello")
    public Employee getEmp(Employee employee) {
        Employee emp = employeeService.updateEmp(employee);
        System.out.println(emp);
        return emp;
    }

    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeService.deleteEmp(id);
        return "success";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("helloworld", "helloworld");
        return "success";
    }
}