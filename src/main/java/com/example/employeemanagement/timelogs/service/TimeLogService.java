package com.example.employeemanagement.timelogs.service;

import com.example.employeemanagement.timelogs.request.TimeLogRequest;
import com.example.employeemanagement.timelogs.response.TimeLogResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TimeLogService {

    public List<TimeLogResponse> findAllEntity();

    public TimeLogResponse findById(Long Id);

    public TimeLogResponse updateEntity(Long Id);

    public String addEntity(TimeLogRequest timeLogRequest);

}

