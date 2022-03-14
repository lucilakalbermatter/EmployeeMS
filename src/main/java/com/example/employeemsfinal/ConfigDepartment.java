package com.example.employeemsfinal;

import com.example.employeemsfinal.dao.DepartmentsRepository;
import com.example.employeemsfinal.entity.EmployeeDepartment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigDepartment {

    @Bean
    CommandLineRunner commandLineRunner(
            DepartmentsRepository repository){
        return args -> {
            EmployeeDepartment IT =  new EmployeeDepartment(

                    "Web Design"

            );

            repository.save(IT);


        };
    }
}
