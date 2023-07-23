package com.jasdhir;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.jasdhir.entity.Employee;
import com.jasdhir.repository.EmployeeRepository;

@Sql(scripts = "/insertData.sql")
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void fetchData() {
		List<Employee> empList=employeeRepository.findAll();
		System.out.println(empList);
		assertEquals(2, empList.size());
	}

}
