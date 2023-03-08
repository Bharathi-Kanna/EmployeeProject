package com.example.employeemanagement.project.entity;

import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import com.example.employeemanagement.project.requests.AddProjectRequest;
import com.example.employeemanagement.project.requests.UpdateProjectRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="project")
public class Project{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private long id;
    @Column(name = "pro_name")
    String projectName;

    @Enumerated(EnumType.STRING)
    ProjectStatus status;

    @Enumerated(EnumType.STRING)
    ProjectType type;

    @Column(name="start_date")
    LocalDate startDate;
    @Column(name="actual_date")
    LocalDate actualDate;
    @Column(name="planned_date")
    LocalDate plannedDate;
    @Column(name="project_valuation")
    Long valuation;

    @OneToMany(mappedBy = "project")
    private List<EmployeeProject> employeeProjects;

    private List<Long> Teams_id;

    private List<Long> jobs_id;

    public Project(AddProjectRequest req){
        this.projectName = req.getName();
    }
    public Project(UpdateProjectRequest req){
        this.id = req.getId();
    }


}
