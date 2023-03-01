package com.example.employeemanagement.teams.service;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employee.response.EmployeeResponse;
import com.example.employeemanagement.employee.response.EmployeeResponseSimple;
import com.example.employeemanagement.employeeproject.entity.EmployeeProject;
import com.example.employeemanagement.employeeproject.service.EmployeeProjectInterface;
import com.example.employeemanagement.teams.entity.Teams;
import com.example.employeemanagement.teams.exception.TeamNotFound;
import com.example.employeemanagement.teams.repository.TeamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamsService implements TeamsServiceInterface{

    @Autowired
    TeamsRepo teamsRepo;

    @Autowired
    EmployeeProjectInterface employeeProjectInterface;

    @Override
    public List<Teams> findAllEntity() {
        return teamsRepo.findAll();
    }
    @Override
    public Teams addEntity(Teams entity) {
        return teamsRepo.save(entity);
    }


    public Teams removeEntity(Long Id) {
        return null;
    }

    @Override
    public void deleteById(Long Id) {
        teamsRepo.deleteById(Id);
    }

    @Override
    public Teams updateEntity(Long id,Teams entity) {
        return teamsRepo.save(entity);
    }

    @Override
    public Teams findEntityById(Long Id) {
        return teamsRepo.findById(Id).orElseThrow(() -> new TeamNotFound("Team nod found with" + Id));
    }

    @Override
    public List<Teams> findByProject(Long Id) {
       return teamsRepo.findByProject(Id);
    }

    @Override
    public List<EmployeeResponseSimple> findALlEmployeeTeam(Long id) {
        List<EmployeeProject> employeeProject = employeeProjectInterface.findAllEntity();
        List<EmployeeResponseSimple> employees = new ArrayList<>();
        for(EmployeeProject e: employeeProject){
            if(e.getTeams().getId() == id){
                EmployeeResponseSimple employeeResponseSimple = new EmployeeResponseSimple();
                employeeResponseSimple.setId(e.getEmployee().getEmployeeId());
                employeeResponseSimple.setName(e.getEmployee().getName());
                employees.add(employeeResponseSimple);
            }
        }
        return employees;
    }
}

