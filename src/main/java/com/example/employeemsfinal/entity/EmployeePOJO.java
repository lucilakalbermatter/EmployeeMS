package com.example.employeemsfinal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;

@Getter
@Setter
@AllArgsConstructor
public class EmployeePOJO {
    private String employeeName;
    private String userName;
    private String password;


}
