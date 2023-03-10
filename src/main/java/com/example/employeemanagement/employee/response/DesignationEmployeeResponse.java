package com.example.employeemanagement.employee.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesignationEmployeeResponse {
    private Long designationId;
    private List<Long> employeeList;

}
