package com.example.employeemanagement.project.requests;

import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AddProjectRequest {
    private String name;
    //private List<Long> emp_pro_id;
    private ProjectStatus status;

    private ProjectType type;

    private LocalDate startDate;

    private LocalDate actualDate;

    private LocalDate plannedDate;

    private Long valuation;

}
