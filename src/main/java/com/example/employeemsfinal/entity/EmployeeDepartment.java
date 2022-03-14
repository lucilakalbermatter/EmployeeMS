package com.example.employeemsfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//This class can be mapped to a table
@Entity
public class EmployeeDepartment {

    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Long id;
    private String departmentName;

    public EmployeeDepartment(String departmentName) {
        this.departmentName = departmentName;
    }
}
