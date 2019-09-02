package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Employee;
import com.atguigu.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emps")
    public String list(Model model) {
        List<Employee> employees = employeeService.getAll();
//        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String add(Model model) {
//        List<Department> departments = departmentReponsitory.findAll();
//        Collection<Department> departments = departmentDao.getDepartments();
//        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String saveEmp(Employee employee) {
        System.out.println(employee.getLastName());
//        employeeReponsitory.save(employee);
//        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
//        Employee employee = employeeReponsitory.getOne(id);
//        Employee employee = employeeDao.get(id);
//        model.addAttribute("emp", employee);
//        Collection<Department> departments = departmentDao.getDepartments();
//        List<Department> departments = departmentReponsitory.findAll();
//        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String edit(Employee employee) {
//        employeeReponsitory.save(employee);
//        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable Integer id) {
//        employeeReponsitory.deleteById(id);
//        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
