package com.example.employeeManagementSystem.service;

import com.example.employeeManagementSystem.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void updateEmployee(Employee employee);
    void deleteEmployee(Long id);
}
