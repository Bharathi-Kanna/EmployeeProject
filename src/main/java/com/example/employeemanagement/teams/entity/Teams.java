package com.example.employeemanagement.teams.entity;

import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name="teams")
@Data
@Entity
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    Long Id;
    @Column(name = "team_name")
    String name;
    //@OneToMany(mappedBy = "teams")
    Long project;
    @OneToMany(mappedBy = "teams")
    private List<EmployeeProject> employeeProjects;

}
