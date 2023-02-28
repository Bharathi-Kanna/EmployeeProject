package com.example.employeemanagement.employeeproject.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeProjectRequest {

    private long employee_id;

    private long project_id;

    private long team_id;
}
