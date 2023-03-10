package com.example.employeemanagement.project.service;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.project.exception.ProjectNotFound;
import com.example.employeemanagement.project.repository.ProjectRepo;
import com.example.employeemanagement.project.requests.AddProjectRequest;
import com.example.employeemanagement.project.requests.UpdateProjectRequest;
import com.example.employeemanagement.project.response.ProjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService implements ProjectServiceInterface {

    @Autowired
    ProjectRepo projectRepo;


    @Override
    public List<ProjectResponse> findAllEntities() {
        List<Project> list = projectRepo.findAll();
        List<ProjectResponse> responseList = new ArrayList<>();
        list.forEach(e -> {
            ProjectResponse eResponse = new ProjectResponse(e);
            List<Long> emp_id = new ArrayList<>();
            for(EmployeeProject d : e.getEmployeeProjects()){
                Employee employee = d.getEmployee();
                emp_id.add(employee.getEmployeeId());
            }
            eResponse.setEmployee_id(emp_id);
            responseList.add(eResponse);
        });
        return responseList;
    }

    @Override
    public Project addEntities(AddProjectRequest eReq) {
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Project project = new Project(eReq);
        project.setStatus(eReq.getStatus());
        project.setType(eReq.getType());
        project.setStartDate(eReq.getStartDate());
        project.setActualDate(eReq.getActualDate());
        project.setPlannedDate(eReq.getPlannedDate());
        project.setValuation(eReq.getValuation());
        return projectRepo.save(project);
    }

    @Override
    public Project updateEntities(Long id, UpdateProjectRequest eReq) {
        Project project = projectRepo.findById(eReq.getId()).orElseThrow(() -> new ProjectNotFound("project nod found with" + id));;
        if(eReq.getName()!=null){
            project.setProjectName(eReq.getName());
        }
        if(eReq.getStatus()!=null){
            project.setStatus(eReq.getStatus());
        }
        if(eReq.getType()!=null){
            project.setType(eReq.getType());
        }
        if(eReq.getStartDate()!=null){
            project.setStartDate(eReq.getStartDate());
        }
        if(eReq.getActualDate()!=null){
            project.setActualDate(eReq.getActualDate());
        }
        if(eReq.getPlannedDate()!=null){
            project.setPlannedDate(eReq.getPlannedDate());
        }
        if(eReq.getValuation()!=null){
            project.setValuation(eReq.getValuation());
        }
        return projectRepo.save(project);
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
    public List<Project> findAllEntity() {
        return null;
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
