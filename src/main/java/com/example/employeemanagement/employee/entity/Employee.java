package com.example.employeemanagement.employee.entity;

import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import com.example.employeemanagement.payroll.entity.Payroll;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Long employeeId;
    @NotNull
    @Column(name="emp_name")
    private String name;
    @NotNull
    @Column(name="dep_id")
    private Long departmentId;
    @NotNull
    @Column(name="des_id")
    private Long designationId;
    @NotNull
    @Column(name="emp_phoneNum")
    private String phoneNumber;
    @NotNull
    @Column(name="emp_experience")
    private Float experience;
    @Email
    @Column(name="emp_email")
    private String email;
    @Column(name="emp_DOB")
    private LocalDate dateOfBirth;
    @Column(name="emp_address")
    private String address;
    @NotNull
    @Column(name="emp_type")
    private String employmentType;
    @NotNull
    @Column(name="emp_status")
    private String status;
    @NotNull
    @Column(name="emp_join_date")
    private LocalDate joinDate;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeProject> employeeProjects;
    @OneToOne(cascade = CascadeType.ALL)
    private Payroll payroll;
    @Column(name="emp_left_date")
    private LocalDate leftDate;
    @JsonIgnore
    private Date dataEnteredDateTime = new Date();


}
