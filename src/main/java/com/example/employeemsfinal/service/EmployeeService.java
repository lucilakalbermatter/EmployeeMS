package com.example.employeemsfinal.service;


import com.example.employeemsfinal.dao.DepartmentsRepository;
import com.example.employeemsfinal.dao.EmployeeRepository;
import com.example.employeemsfinal.entity.EmployeeDepartment;
import com.example.employeemsfinal.entity.EmployeeModel;
import com.example.employeemsfinal.entity.EmployeePOJO;
import com.example.employeemsfinal.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements UserDetailsService {

   private final EmployeeRepository employeeRepository;



  //create methods for find all, save, delete //see class employeeController
  public List <EmployeeModel> findEmployee(){
    return employeeRepository.findAll();
  }


  public EmployeeModel saveEmployee(EmployeePOJO employeePojo){



    EmployeeModel newEmployee = new EmployeeModel();
            newEmployee.setEmployeeName(employeePojo.getEmployeeName());
            newEmployee.setUserName(employeePojo.getUserName());
            newEmployee.setPassword(employeePojo.getPassword());
            newEmployee.setEmployeeRole(Role.EMPLOYEE);



    return employeeRepository.save(newEmployee);
  }

  //inside this method call a method from repo. -->findById
  //create an object of employeeModel
  //delete this object, which belongs to this id
  public void deleteEmployee(String username){
    EmployeeModel employeeRemoval = employeeRepository.findByUserName(username);
    employeeRepository.delete(employeeRemoval);

  }

  public void updateEmployee(String username, String newName){
    EmployeeModel employeeUpdate = employeeRepository.findByUserName(username);
    employeeUpdate.setEmployeeName(newName);

  }

  public EmployeeModel getUser(String username){
  return employeeRepository.findByUserName(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    EmployeeModel employee= employeeRepository.findByUserName(username);

    if(employee == null){
      throw new UsernameNotFoundException("Employee not found");
    }

   Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();



    return new org.springframework.security.core.userdetails.User(employee.getUsername(),employee.getPassword(),employee.getAuthorities());
  }


}
