package com.huawei.b00314808.finance;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.huawei.b00314808.finance.domain.BillMapper;
import com.huawei.b00314808.finance.domain.Employee;
import com.huawei.b00314808.finance.domain.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyAccountApplicationTests {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private BillMapper billMapper;
    
	@Test
	public void contextLoads() {
	   // employeeMapper.insert("AAA", "aaa");
//        List<Employee> employeeList = employeeMapper.findAll();

//        for(Employee employee : employeeList) {
//            System.out.println(employee.getName());
//        }
	       //System.out.println(employeeMapper.findByName("aa"));


	       
	}
	
}
