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
        employeeService.findAll().forEach(result::add);
        return result;
    }


    @GetMapping(value = "/{id}")
    public EmployeeModel getUser(@PathVariable(value = "id") long id){
        return employeeService.findById(id)
                .orElseThrow();
    }

    @PostMapping
    public EmployeeModel addEmployee(@RequestBody EmployeeModel newEmployee){
        return employeeService.save(newEmployee);
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete (@PathVariable("id") Long id){
        employeeService.deleteById(id);
    }
}



