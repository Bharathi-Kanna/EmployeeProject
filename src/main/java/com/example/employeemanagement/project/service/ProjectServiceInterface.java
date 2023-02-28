package com.example.employeemanagement.project.service;

import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.generics.ServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectServiceInterface extends ServiceInterface<Project> {
    public List<Project> findByStatus(ProjectStatus status);
    public List<Project> findByType(ProjectType type);

}
