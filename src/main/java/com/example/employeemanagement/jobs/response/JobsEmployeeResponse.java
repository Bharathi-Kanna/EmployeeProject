package com.example.employeemanagement.jobs.response;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.jobs.entity.Jobs;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobsEmployeeResponse {
    private Long id;
    private String employeeName;

    public JobsEmployeeResponse(Employee employee){
        this.id = employee.getEmployeeId();
        this.employeeName = employee.getName();
    }
}
