package com.example.employee.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 import org.springframework.web.bind.annotation.*;
 import java.util.*;
 import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeJpaService;
 @RestController
 @Component
 public class EmployeeController{
    
    @Autowired
    public EmployeeJpaService service;

    @GetMapping("/employees")
    public String getAllEmployees(){
    return "Hello World";
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee){
        return service.postEmployee(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int id){
        return service.getEmployee(id);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee modifyEmployee(@PathVariable("employeeId") int id,@RequestBody Employee employee){
        return service.putEmployee(id,employee);
    }
    
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployeeById(@PathVariable("employeeId") int id){
        service.deleteEmployee(id);
    }
 }