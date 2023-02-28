package com.example.employeemanagement.project.requests;

import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProjectRequest {
    private String name;
    //private List<Long> emp_pro_id;
    private ProjectStatus status;

    private ProjectType type;

    private String startDate;

    private String endDate;

    private Long valuation;

}
