package com.example.employeemanagement.project.response;

import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import com.example.employeemanagement.project.entity.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@NoArgsConstructor
@Getter
public class ProjectResponse {
    private Long id;
    private String projectName;
    private ProjectStatus status;
    private ProjectType type;
    private LocalDate startDate;
    private LocalDate actualDate;
    private LocalDate plannedDate;
    private Long valuation;
    private List<Long> employee_id;

    private List<Long> teams_id;

    public ProjectResponse(Project project){
        this.id = project.getId();
        this.projectName = project.getProjectName();
        this.status = project.getStatus();
        this.type = project.getType();
        this.startDate = project.getStartDate();
        this.actualDate = project.getActualDate();
        this.plannedDate = project.getPlannedDate();
        this.valuation = project.getValuation();
        this.teams_id = project.getTeams_id();
    }


}
