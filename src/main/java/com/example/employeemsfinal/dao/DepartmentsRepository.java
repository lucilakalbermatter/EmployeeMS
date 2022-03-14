package com.example.employeemsfinal.dao;

import com.example.employeemsfinal.entity.EmployeeDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<EmployeeDepartment, Long> {

}
