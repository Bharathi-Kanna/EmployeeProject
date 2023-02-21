package com.example.EmployeeManagement.response;


import com.example.EmployeeManagement.entity.entities.Payroll;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse  {

    private Long employeeId;

    private String name;

    private String departmentName;

    private String designationName;

    private String phoneNumber;

    private String email;

    private LocalDate dateOfBirth;

    private String address;
    private Float experience;
    private String employmentType;

    private Payroll payroll;
    private String status;

    private LocalDate joinDate;

    private LocalDate leftDate;


}
