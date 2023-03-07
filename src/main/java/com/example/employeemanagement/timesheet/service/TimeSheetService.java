package com.example.employeemanagement.timesheet.service;

import com.example.employeemanagement.timesheet.request.TimeSheetRequest;
import com.example.employeemanagement.timesheet.response.TimeSheetResponse;

import java.util.List;

public interface TimeSheetService {
    public List<TimeSheetResponse> findAllEntity();

    public TimeSheetResponse findById(Long Id);

    public TimeSheetResponse updateEntity(TimeSheetRequest eReq, Long id);

    public String addEntity(TimeSheetRequest timeSheetRequest);
}
