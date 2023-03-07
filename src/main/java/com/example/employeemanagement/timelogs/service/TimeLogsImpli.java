package com.example.employeemanagement.timelogs.service;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employee.repository.EmployeeRepo;
import com.example.employeemanagement.exception.EntityNotFound;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.project.repository.ProjectRepo;
import com.example.employeemanagement.project.requests.UpdateProjectRequest;
import com.example.employeemanagement.timelogs.entity.TimeLogs;
import com.example.employeemanagement.timelogs.repository.TimeLogRepo;
import com.example.employeemanagement.timelogs.request.TimeLogRequest;
import com.example.employeemanagement.timelogs.response.TimeLogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeLogsImpli implements TimeLogService{


    @Autowired
    TimeLogRepo timeLogRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public List<TimeLogResponse> findAllEntity() {
        List<TimeLogs> timeLogs = timeLogRepo.findAll();
        List<TimeLogResponse> list = new ArrayList<>();
        for (TimeLogs e:
             timeLogs) {
            TimeLogResponse timeLogResponse = new TimeLogResponse(e);
            Employee employee = employeeRepo.findById(e.getEmployeeId()).orElseThrow(()-> new EntityNotFound("employee not found"));
            Project project = projectRepo.findById(e.getProjectId()).orElseThrow(()-> new EntityNotFound("project not found"));
            timeLogResponse.setEmployeeName(employee.getName());
            timeLogResponse.setProjectName(project.getProjectName());
            list.add(timeLogResponse);
        }
        return list;
    }

    @Override
    public TimeLogResponse findById(Long Id) {
        return new TimeLogResponse(timeLogRepo.findById(Id)
                .orElseThrow(()-> new EntityNotFound("time log not found with id:" + Id)));
    }

    @Override
    public TimeLogResponse updateEntity(TimeLogRequest eReq,Long Id) {
        return null;
    }

    @Override
    public String addEntity(TimeLogRequest eReq) {
        TimeLogs timeLogs = new TimeLogs();
        timeLogs.setEmployeeId(eReq.getEmployeeId());
        timeLogs.setProjectId(eReq.getProjectId());
        timeLogs.setLogTime(LocalDateTime.now());
        timeLogs.setStartDate(eReq.getStartDate());
        timeLogs.setEndDate(eReq.getEndDate());
        timeLogs.setLoggedHours(eReq.getLoggedHours());
        timeLogRepo.save(timeLogs);
        return "Time Log Added";
    }

}
