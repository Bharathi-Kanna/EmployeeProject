package com.example.employeemanagement.project.requests;

import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateProjectRequest {
    private String name;
    private Long id;
    private ProjectStatus status;
    private ProjectType type;
    private String startDate;
    private String endDate;

    private Long valuation;
}
