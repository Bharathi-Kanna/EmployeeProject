package com.example.employeemanagement.employeeproject.controller;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employee.services.serviceinterface.EmployeeServiceInterface;
import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import com.example.employeemanagement.employeeproject.requests.AddEmployeeList;
import com.example.employeemanagement.employeeproject.requests.EmployeeProjectRequest;
import com.example.employeemanagement.employeeproject.requests.ProjectTeamRequest;
import com.example.employeemanagement.employeeproject.response.EmployeeProjectResponse;
import com.example.employeemanagement.employeeproject.service.EmployeeProjectInterface;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.project.service.ProjectServiceInterface;
import com.example.employeemanagement.teams.entity.Teams;
import com.example.employeemanagement.teams.service.TeamsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employeeProjectTeam")
public class EmployeeProjectController {

    @Autowired
    EmployeeProjectInterface employeeProjectInterface;

    @Autowired
    EmployeeServiceInterface employeeServicesInterface;

    @Autowired
    ProjectServiceInterface projectServiceInterface;

    @Autowired
    TeamsServiceInterface teamsServiceInterface;

    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeProjectResponse>> findAllEntities() {

        List<EmployeeProject> list = employeeProjectInterface.findAllEntity();
        List<EmployeeProjectResponse> responseList = new ArrayList<>();
        list.forEach(e ->{
            EmployeeProjectResponse eResponse = new EmployeeProjectResponse();
            eResponse.setId(e.getId());
            Employee employee = e.getEmployee();
            Project project = e.getProject();
            Teams teams = e.getTeams();
            eResponse.setEmployee_id(employee.getEmployeeId());
            eResponse.setProject_id(project.getId());
            eResponse.setTeam_id(teams.getId());
            responseList.add(eResponse);
        });
        return new ResponseEntity<List<EmployeeProjectResponse>>(responseList, HttpStatus.OK);
    }

    // adds employee to projects and teams
    @PostMapping("/add/{id}")
    public ResponseEntity<String> addEntities(@RequestBody EmployeeProjectRequest eReq,@PathVariable("id") Long id){
            Employee employee = employeeServicesInterface.findEntityById(eReq.getEmployeeId());
            Project project = projectServiceInterface.findEntityById(eReq.getProjectId());
            Teams teams = teamsServiceInterface.findEntityById(eReq.getTeamId());
            EmployeeProject employeeProject = new EmployeeProject();
            employeeProject.setEmployee(employee);
            employeeProject.setProject(project);
            employeeProject.setTeams(teams);
            employeeServicesInterface.updateEntity(id,employee);
            projectServiceInterface.addEntity(project);
            teamsServiceInterface.addEntity(teams);
            employeeProjectInterface.addEntity(employeeProject);
        return new ResponseEntity<String>("relation saved", HttpStatus.OK) ;
    }

    //add multiple employee to single team as list
    @PostMapping("/add")
    public ResponseEntity<String> addMultiEntities(@RequestBody AddEmployeeList eReq){
        Project project = projectServiceInterface.findEntityById(eReq.getProjectId());
        Teams teams = teamsServiceInterface.findEntityById(eReq.getTeamId());
        for (Long l:
                eReq.getEmployeeId()) {
            Employee employee = employeeServicesInterface.findEntityById(l);
            EmployeeProject employeeProject = new EmployeeProject();
            employeeProject.setProject(project);
            employeeProject.setTeams(teams);
            employeeProject.setEmployee(employee);
            employeeServicesInterface.updateEntity(l,employee);
            projectServiceInterface.addEntity(project);
            teamsServiceInterface.addEntity(teams);
            employeeProjectInterface.addEntity(employeeProject);
        }
        return new ResponseEntity<String>("relation saved", HttpStatus.OK) ;
    }

    //adds teams to projects
    @PostMapping("/addTeamProject")
    public ResponseEntity<String> addTeamsProjects(@RequestBody ProjectTeamRequest eReq){
        Teams teams = teamsServiceInterface.findEntityById(eReq.getTeam_id());
        Project project = projectServiceInterface.findEntityById(eReq.getProject_id());
        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setTeams(teams);
        employeeProject.setProject(project);
        teamsServiceInterface.addEntity(teams);
        projectServiceInterface.addEntity(project);
        employeeProjectInterface.addEntity(employeeProject);
        return new ResponseEntity<String>("relation saved", HttpStatus.OK);
    }

    //returns all employees in the team
}
