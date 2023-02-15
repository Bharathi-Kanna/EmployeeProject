package com.example.EmployeeManagement.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse  {

    private Long employee_id;

    private String name;

    private String departmentName;

    private String designationName;

    private String phoneNumber;

    private String email;

    private LocalDate dateOfBirth;

    private String address;

    private String status;

    private LocalDate joinDate;

    private LocalDate leftDate;


}
