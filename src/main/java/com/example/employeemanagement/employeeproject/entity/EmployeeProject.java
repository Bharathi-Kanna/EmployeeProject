package com.example.employeemanagement.employeeproject.entity;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.teams.entity.Teams;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "EmployeeProjectTeam")
@Entity
public class EmployeeProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name= "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Teams teams;
}
