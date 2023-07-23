package com.jasdhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jasdhir.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
