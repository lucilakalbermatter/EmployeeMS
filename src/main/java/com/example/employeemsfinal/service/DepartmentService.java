package com.example.employeemsfinal.service;

import com.example.employeemsfinal.dao.DepartmentsRepository;
import com.example.employeemsfinal.entity.EmployeeDepartment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentsRepository departmentsRepository;

    public EmployeeDepartment addDepartment(String newDepartmentString) {

        EmployeeDepartment newDepartment = new EmployeeDepartment(newDepartmentString);


        return departmentsRepository.save(newDepartment);
    }
}
