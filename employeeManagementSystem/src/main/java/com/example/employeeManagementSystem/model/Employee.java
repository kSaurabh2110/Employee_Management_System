package com.example.employeeManagementSystem.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    //TODO calculate age afterwards
    @Column(name = "date_of_joining")
    @NotNull
    private Date doj;

    @Column(name = "phone_number",unique = true,precision = 10)
    @NotNull
    private String phoneNumber;

    @Column(name = "email",unique = true)
    @NotNull
    private String email;

    //TODO set to default
    @Column(name = "salary")
    @NotNull
    private Long salary;

}
