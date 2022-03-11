package com.example.employeemsfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value ="/api/employee")
public class EmployeeController {

    @Autowired  //use this annotation instead of making a constructor
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeModel> findAll() {
        List<EmployeeModel> result = new ArrayList<>();
        employeeRepository.findAll().forEach(result::add);
        return result;
    }


    @GetMapping(value = "/{id}")
    public EmployeeModel getUser(@PathVariable(value = "id") long id){
        return employeeRepository.findById(id)
                .orElseThrow();
    }

    @PostMapping
    public EmployeeModel addEmployee(@RequestBody EmployeeModel newEmployee){
        return employeeRepository.save(newEmployee);
    }

    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete (@PathVariable("id") Long id){
        employeeRepository.deleteById(id);
    }
}



