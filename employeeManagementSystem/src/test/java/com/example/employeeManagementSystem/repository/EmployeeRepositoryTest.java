package com.example.employeeManagementSystem.repository;

import com.example.employeeManagementSystem.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Test
    public void addEntry(){
        Calendar calendar=Calendar.getInstance();
        Employee emp=Employee.builder()
                .firstName("Saurabh")
                .lastName("Kumar")
                .doj(new Date(calendar.get(Calendar.YEAR)-1900,01,01))
                .phoneNumber("7652983577")
                .email("skumar@gmail.com")
                .salary(1200000L)
                .build();
        employeeRepository.save(emp);
    }
}