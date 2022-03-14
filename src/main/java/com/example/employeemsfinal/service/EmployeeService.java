package com.example.employeemsfinal.service;


import com.example.employeemsfinal.EmployeeModel;
import com.example.employeemsfinal.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

   private final EmployeeRepository employeeRepository;


  //create methods for find all, save, delete //see class employeeController
  public List <EmployeeModel> findEmployee(){
    return employeeRepository.findAll();
  }


  public EmployeeModel saveEmployee(EmployeeModel employeeModel){
    return employeeRepository.save(employeeModel);
  }

  //inside this method call a method from repo. -->findById
  //create an object of employeeModel
  //delete this object, which belongs to this id
  public void deleteEmployee(String username){
    EmployeeModel employeeRemoval = EmployeeRepository.findByUserName(username);
    employeeRepository.delete(employeeRemoval);

  }

  public void updateEmployee(String username, String newName){
    EmployeeModel employeeUpdate = EmployeeRepository.findByUserName(username);
    employeeUpdate.setEmployeeName(newName);

  }

}
