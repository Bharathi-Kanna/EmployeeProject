package com.example.employeemanagement.timesheet.service;

import com.example.employeemanagement.exception.EntityNotFound;
import com.example.employeemanagement.timesheet.entity.TimeSheet;
import com.example.employeemanagement.timesheet.repository.TimeSheetRepo;
import com.example.employeemanagement.timesheet.request.TimeSheetRequest;
import com.example.employeemanagement.timesheet.response.TimeSheetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeSheetImpli implements TimeSheetService{

    @Autowired
    TimeSheetRepo timeSheetRepo;
    @Override
    public List<TimeSheetResponse> findAllEntity() {
        return null;
    }

    @Override
    public TimeSheetResponse findById(Long Id) {
        TimeSheet timeSheet = timeSheetRepo.findById(Id).orElseThrow(()-> new EntityNotFound("timesheet not found"));
        TimeSheetResponse timeSheetResponse = new TimeSheetResponse(timeSheet);
        return timeSheetResponse;
    }

    @Override
    public TimeSheetResponse updateEntity(TimeSheetRequest eReq, Long id) {
        return null;
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
