package com.example.employeemsfinal.controller;

import com.example.employeemsfinal.entity.EmployeeDepartment;
import com.example.employeemsfinal.entity.EmployeeModel;
import com.example.employeemsfinal.entity.EmployeePOJO;
import com.example.employeemsfinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api/employee")
public class EmployeeController {

    @Autowired  //use this annotation instead of making a constructor
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeModel> findAll() {
       return employeeService.findEmployee();

    }


    @GetMapping(value = "/{username}")
    public EmployeeModel getUser(@PathVariable(value = "username") String username){
        return employeeService.getUser(username);
    }

  @PostMapping
  public EmployeeModel addEmployee(@RequestBody EmployeePOJO newEmployee) {
    return employeeService.saveEmployee(newEmployee);
        }
}



