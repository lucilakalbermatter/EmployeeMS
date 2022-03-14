package com.example.employeemsfinal.dao;

import com.example.employeemsfinal.entity.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

    EmployeeModel findByUserName(String userName);

}
