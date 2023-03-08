package com.example.employeemanagement.project.requests;

import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UpdateProjectRequest {
    private String name;
    private Long id;
    private ProjectStatus status;
    private ProjectType type;
    private LocalDate startDate;
    private LocalDate actualDate;
    private LocalDate plannedDate;
    private Long valuation;

}
