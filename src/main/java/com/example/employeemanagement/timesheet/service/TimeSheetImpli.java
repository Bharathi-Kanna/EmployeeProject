package com.example.employeemanagement.timesheet.service;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employee.repository.EmployeeRepo;
import com.example.employeemanagement.exception.EntityNotFound;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.project.repository.ProjectRepo;
import com.example.employeemanagement.timelogs.response.TimeLogResponse;
import com.example.employeemanagement.timesheet.entity.TimeSheet;
import com.example.employeemanagement.timesheet.repository.TimeSheetRepo;
import com.example.employeemanagement.timesheet.request.TimeSheetRequest;
import com.example.employeemanagement.timesheet.response.TimeSheetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSheetImpli implements TimeSheetService{

    @Autowired
    TimeSheetRepo timeSheetRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ProjectRepo projectRepo;

    @Override
    public List<TimeSheetResponse> findAllEntity() {
        List<TimeSheet> timeSheet = timeSheetRepo.findAll();
        List<TimeSheetResponse> list = new ArrayList<>();
        for (TimeSheet e:
                timeSheet) {
            TimeSheetResponse timeSheetResponse = new TimeSheetResponse(e);
            Employee employee = employeeRepo.findById(e.getEmployeeId()).orElseThrow(()-> new EntityNotFound("employee not found"));
            Project project = projectRepo.findById(e.getProjectId()).orElseThrow(()-> new EntityNotFound("project not found"));
            timeSheetResponse.setEmployeeName(employee.getName());
            timeSheetResponse.setProjectName(project.getProjectName());
            list.add(timeSheetResponse);
        }
        return list;
    }

    @Override
    public TimeSheetResponse findById(Long Id) {
        TimeSheet timeSheet = timeSheetRepo.findById(Id).orElseThrow(()-> new EntityNotFound("timesheet not found"));
        TimeSheetResponse timeSheetResponse = new TimeSheetResponse(timeSheet);
        Employee employee = employeeRepo.findById(timeSheetResponse.getEmployeeId()).orElseThrow(()-> new EntityNotFound("employee not found"));
        Project project = projectRepo.findById(timeSheetResponse.getProjectId()).orElseThrow(()-> new EntityNotFound("project not found"));
        timeSheetResponse.setEmployeeName(employee.getName());
        timeSheetResponse.setProjectName(project.getProjectName());
        return timeSheetResponse;
    }

    @Override
    public String updateEntity(TimeSheetRequest eReq, Long id) {
        TimeSheet timeSheet = timeSheetRepo.findById(eReq.getId()).orElseThrow(()->new EntityNotFound("timesheet not found with id: " + id));
        if(eReq.getId()!=null){
            timeSheet.setId(eReq.getId());
        }
        if(eReq.getEmployeeId()!=null){
            timeSheet.setEmployeeId(eReq.getEmployeeId());
        }
        if(eReq.getLogTime()!=null){
            timeSheet.setLogTime(eReq.getLogTime());
        }
        if(eReq.getProjectId()!=null){
            timeSheet.setProjectId(eReq.getProjectId());
        }
        if(eReq.getTotalCost()!=null){
            timeSheet.setTotalCost(eReq.getTotalCost());
        }
        if(eReq.getHoursWorked()!=null){
            timeSheet.setHoursWorked(eReq.getHoursWorked());
        }
        timeSheetRepo.save(timeSheet);
        return "relation saved";
    }

    @Override
    public String addEntity(TimeSheetRequest eReq) {
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setEmployeeId(eReq.getEmployeeId());
        timeSheet.setProjectId(eReq.getProjectId());
        timeSheet.setLogTime(LocalDateTime.now());
        timeSheet.setHoursWorked(eReq.getHoursWorked());
        timeSheet.setTotalCost(eReq.getTotalCost());
        timeSheetRepo.save(timeSheet);
        return "time sheet Added";
    }

}
