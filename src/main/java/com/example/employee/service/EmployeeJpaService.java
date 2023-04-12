package com.example.employee.service;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
 import org.springframework.web.server.ResponseStatusException;
 import java.util.*;

import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.model.Employee;
 
 @Service
 @Component
 public class EmployeeJpaService implements EmployeeRepository{
    
    @Autowired
    public EmployeeJpaRepository db;

   @Override
    public ArrayList<Employee> getEmployees(){
        List<Employee> list= db.findAll();
        ArrayList<Employee> employees=new ArrayList<>(list);
        return employees;
    }

    @Override
    public Employee postEmployee(Employee employee){
      
      Employee postedEmployee = db.save(employee);

        return postedEmployee;
    }

    @Override
    public Employee getEmployee(int id){
       try{
       Employee existingEmployee= db.findById(id).get();
       return existingEmployee;
    }catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    }

    @Override
    public Employee putEmployee(int id, Employee employee){
    
         Employee existingEmployee= getEmployee(id);

        if(employee.getEmployeeName()!=null)
        existingEmployee.setEmployeeName(employee.getEmployeeName());

        if(employee.getEmail()!=null)
       existingEmployee.setEmail(employee.getEmail());

        if(employee.getDepartment()!=null)
       existingEmployee.setDepartment(employee.getDepartment());

    db.save(existingEmployee);

   return existingEmployee;

    }

    @Override
    public void deleteEmployee(int id){
    Employee employee=getEmployee(id);
    db.deleteById(id);
    }


 }