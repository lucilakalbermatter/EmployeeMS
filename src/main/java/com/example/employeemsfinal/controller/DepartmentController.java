package com.example.employeemsfinal.controller;

import com.example.employeemsfinal.entity.EmployeeDepartment;
import com.example.employeemsfinal.service.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/departments/")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public EmployeeDepartment addDepartmentPost(@RequestBody String newDepartment){
        return departmentService.addDepartment(newDepartment);
    }
}
