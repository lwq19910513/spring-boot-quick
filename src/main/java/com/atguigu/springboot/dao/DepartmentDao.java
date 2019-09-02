package com.atguigu.springboot.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.springboot.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

//	private static Map<Integer, Department> departments = null;
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
//	static{
//		departments = new HashMap<Integer, Department>();
//
//		departments.put(101, new Department(101, "D-AA"));
//		departments.put(102, new Department(102, "D-BB"));
//		departments.put(103, new Department(103, "D-CC"));
//		departments.put(104, new Department(104, "D-DD"));
//		departments.put(105, new Department(105, "D-EE"));
//	}
//
//	public Collection<Department> getDepartments() {
//	    List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
//        for(Map<String, Object> map:list) {
//            System.out.println(map);
//        }
//		return departments.values();
//	}
//
//	public Department getDepartment(Integer id){
//		return departments.get(id);
//	}
	
}
