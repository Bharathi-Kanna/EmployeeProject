package com.example.employeemanagement.project.controller;
import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import com.example.employeemanagement.employeeproject.service.EmployeeProjectInterface;
import com.example.employeemanagement.project.Enums.ProjectStatus;
import com.example.employeemanagement.project.Enums.ProjectType;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.project.requests.AddProjectRequest;
import com.example.employeemanagement.project.requests.UpdateProjectRequest;
import com.example.employeemanagement.project.response.ProjectEmpoyeeResponse;
import com.example.employeemanagement.project.response.ProjectResponse;
import com.example.employeemanagement.project.service.ProjectServiceInterface;
import com.example.employeemanagement.teams.entity.Teams;
import com.example.employeemanagement.teams.service.TeamsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController{


    @Autowired
    ProjectServiceInterface projectServiceInterface;

    @Autowired
    EmployeeProjectInterface employeeProjectInterface;


    @Autowired
    TeamsServiceInterface teamsServiceInterface;
    @PostMapping("/add")
    public ResponseEntity<String> addEntities(@RequestBody AddProjectRequest eReq) {
        projectServiceInterface.addEntities(eReq);
        return new ResponseEntity<>("project added", HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEntities(@RequestBody UpdateProjectRequest eReq ,@PathVariable("id") Long id) {
        projectServiceInterface.updateEntities(id,eReq);
        return new ResponseEntity<>("project updated", HttpStatus.OK);
    }

    //returns all project with details
    @GetMapping("/findAll")
    public ResponseEntity<List<ProjectResponse>> findAllEntities() {
        List<ProjectResponse> responseList = projectServiceInterface.findAllEntities();
        return new ResponseEntity<List<ProjectResponse>>(responseList, HttpStatus.OK);
    }

    //returns details of project
    @GetMapping("/findById/{id}")
    public ResponseEntity<ProjectResponse> findById(@PathVariable Long id){
        Project project = projectServiceInterface.findEntityById(id);
        ProjectResponse eResponse = new ProjectResponse(project);
        List<Long> emp_id = new ArrayList<>();
        for(EmployeeProject d : project.getEmployeeProjects()){
            Employee employee = d.getEmployee();
            emp_id.add(employee.getEmployeeId());
        }
        eResponse.setEmployee_id(emp_id);
        return new ResponseEntity<ProjectResponse>(eResponse, HttpStatus.OK) ;
    }

   // returns all employee in a project
    @GetMapping("/findAllEmployee/{id}")
    public ResponseEntity<List<ProjectEmpoyeeResponse>> findAllEmployeeProject(@PathVariable Long id){
        Project project = projectServiceInterface.findEntityById(id);
        List<ProjectEmpoyeeResponse> employeeList = new ArrayList<>();
        for(EmployeeProject d : project.getEmployeeProjects()){
            Employee employee = d.getEmployee();
            ProjectEmpoyeeResponse projectEmpoyeeResponse = new ProjectEmpoyeeResponse();
            projectEmpoyeeResponse.setName(employee.getName());
            projectEmpoyeeResponse.setId(employee.getEmployeeId());
            employeeList.add(projectEmpoyeeResponse);
        }
        return new ResponseEntity<List<ProjectEmpoyeeResponse>>(employeeList, HttpStatus.OK) ;
    }

    //return all projects based on status
    @GetMapping("findAll/{status}")
    public ResponseEntity<List<ProjectResponse>> findByStatus(@PathVariable("status") ProjectStatus status){
        List<Project> list = projectServiceInterface.findByStatus(status);
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
        return new ResponseEntity<List<ProjectResponse>>(responseList, HttpStatus.OK) ;
    }

    //return all projects based on type
    @GetMapping("find-all/type/{type}")
    public ResponseEntity<List<ProjectResponse>> findByType(@PathVariable("type") ProjectType type){
        List<Project> list = projectServiceInterface.findByType(type);
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
        return new ResponseEntity<List<ProjectResponse>>(responseList, HttpStatus.OK) ;
    }

    //return all teams in project

    @GetMapping("/findAll/teams/{id}")
    public ResponseEntity<List<Teams>> findAllTeams(@PathVariable Long id){
        List<Teams>list = teamsServiceInterface.findByProject(id);
        return new ResponseEntity<List<Teams>>(list, HttpStatus.OK) ;
    }

}
