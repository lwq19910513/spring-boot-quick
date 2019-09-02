package com.atguigu.springboot;

import com.atguigu.springboot.been.Person;
import com.atguigu.springboot.entities.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot01HelloworldQuickApplicationTests {

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Autowired
    DataSource dataSource;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, Object> objectObjectRedisTemplate;

    @Test
    public void testHelloService() {
        boolean b = ioc.containsBean("helloService");
        System.out.println(b);
    }

    @Test
    public void contextLoads() {
        System.out.println(person);
        logger.trace("这是trace日志。。。");
        logger.debug("这是debug日志。。。");
        logger.info("这是info日志。。。");
        logger.warn("这是warn日志。。。");
        logger.error("这是error日志。。。");
    }

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testMyBaties() throws ParseException {
//        Employee employee = new Employee();
//        employee.setLastName("张三");
//        employee.setEmail("aaaa@qq.com");
//        employee.setGender(1);
//        employee.setdId(1);
//        employee.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1991-05-13"));
//        employeeMapper.insertEmp(employee);
        Employee emp = employeeMapper.getEmpById(2);
        System.out.println(emp);
    }

    @Test
    public void redisTest01() {
//        stringRedisTemplate.opsForValue().append("msg", "gugugu");
//        System.out.println(stringRedisTemplate.opsForValue().get("msg"));
//        Employee employee = employeeMapper.getEmpById(3);
//        Employee employee1 = employeeMapper.getEmpById(2);
//        objectObjectRedisTemplate.opsForValue().set("emp-02", employee);
//        objectObjectRedisTemplate.opsForList().leftPush("emp", employee);
//        objectObjectRedisTemplate.opsForList().leftPush("emp", employee1);
        List<Employee> list = employeeMapper.getEmps();
        objectObjectRedisTemplate.opsForList().leftPush("emp", list);
    }

}
