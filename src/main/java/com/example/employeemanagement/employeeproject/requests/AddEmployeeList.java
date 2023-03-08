package com.example.employeemanagement.employeeproject.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddEmployeeList {

    private Long projectId;
    private Long teamId;
    private List<Long> employeeId;

}
