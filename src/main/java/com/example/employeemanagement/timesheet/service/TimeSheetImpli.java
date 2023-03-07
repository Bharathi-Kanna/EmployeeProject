package com.example.employeemanagement.timesheet.service;

import com.example.employeemanagement.timesheet.request.TimeSheetRequest;
import com.example.employeemanagement.timesheet.response.TimeSheetResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSheetImpli implements TimeSheetService{
    @Override
    public List<TimeSheetResponse> findAllEntity() {
        return null;
    }

    @Override
    public TimeSheetResponse findById(Long Id) {
        return null;
    }

    @Override
    public TimeSheetResponse updateEntity(TimeSheetRequest eReq, Long id) {
        return null;
    }

    @Override
    public String addEntity(TimeSheetRequest timeSheetRequest) {
        return null;
    }
}
