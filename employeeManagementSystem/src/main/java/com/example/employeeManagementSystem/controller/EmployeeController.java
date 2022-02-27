package com.example.employeeManagementSystem.controller;

import com.example.employeeManagementSystem.model.Employee;
import com.example.employeeManagementSystem.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    //handler method to handle list of employees and return model and view
    //list of employees
    @GetMapping("/employees")
    public String listEmployees(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "employees";
    }



    //create student object to hold employee form data
    @GetMapping("/employee/new")
    public String createEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "create_employee";

    }
    //save data from form
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }



    //update data controller
    @GetMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id,Model model){
        model.addAttribute("employee",employeeService.getEmployeeById(id));
        return "edit_employee";
    }
    //handle update
    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee){

        /*You can simply use this function with save() JPa Function,
        but the object sent as parameter must contain an existing id
        in the database otherwise it will not work, because save()
        when we send an object without id, it adds directly a row in database,
        but if we send an object with an existing id,
        it changes the columns already found in the database.*/

        Employee existingEmployee=employeeService.getEmployeeById(id);
        existingEmployee.setId(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDoj(employee.getDoj());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setSalary(employee.getSalary());

        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    //delete data controller
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

}
