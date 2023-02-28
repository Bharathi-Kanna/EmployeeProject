package com.example.employeemanagement.project.service;

import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.project.exception.ProjectNotFound;
import com.example.employeemanagement.project.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements ProjectServiceInterface {

    @Autowired
    ProjectRepo projectRepo;
    @Override
    public List<Project> findAllEntity() {
        return projectRepo.findAll();
    }

    @Override
    public Project addEntity(Project entity) {
        return projectRepo.save(entity);
    }


    @Override
    public void deleteById(Long Id) {
        projectRepo.deleteById(Id);
    }

    @Override
    public Project updateEntity(Long id,Project entity) {
        return projectRepo.save(entity);
    }

    @Override
    public List<Project> findByStatus(ProjectStatus status){
        return projectRepo.findByStatus(status);
    }

    @Override
    public List<Project> findByType(ProjectType type) {
        return projectRepo.findByType(type);
    }

    @Override
    public Project findEntityById(Long Id) {
        return projectRepo.findById(Id).orElseThrow(() -> new ProjectNotFound("project nod found with" + Id));
    }

}
