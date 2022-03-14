package com.example.employeemsfinal.controller;

import com.example.employeemsfinal.entity.EmployeeModel;
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
        List<EmployeeModel> result = new ArrayList<>();
        employeeService.findEmployee();
        return result;
    }


    @GetMapping(value = "/{username}")
    public EmployeeModel getUser(@PathVariable(value = "username") String username){
        return employeeService.getUser(username);
    }

    @PostMapping
    public EmployeeModel addEmployee(@RequestBody EmployeeModel newEmployee){
        return employeeService.saveEmployee(newEmployee);
    }

    @DeleteMapping(value="/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void delete (@PathVariable("username") String username){
        employeeService.deleteEmployee(username);
    }
}



