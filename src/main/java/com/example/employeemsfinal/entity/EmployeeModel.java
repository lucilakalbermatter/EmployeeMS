package com.example.employeemsfinal.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
//this annotation means that this class can be mapped to a table
@Entity
@Table(name = "employees")
public class EmployeeModel implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String employeeName;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role employeeRole;


    //Many employees can be in one department
    @ManyToOne
    @JoinColumn(nullable = false,
            name = "employeeDepartment_id"
    )
    @Transient
    private EmployeeDepartment employeeDepartment;

    //Constructor without ID because it's generated automatically
    public EmployeeModel(String employeeName, String userName, String password, Role employeeRole) {
        this.employeeName = employeeName;
        this.userName = userName;
        this.password = password;
        this.employeeRole = employeeRole;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(employeeRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}



