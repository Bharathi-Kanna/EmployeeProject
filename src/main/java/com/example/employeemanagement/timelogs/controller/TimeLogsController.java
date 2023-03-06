package com.example.employeemanagement.timelogs.controller;

import com.example.employeemanagement.timelogs.request.TimeLogRequest;
import com.example.employeemanagement.timelogs.response.TimeLogResponse;
import com.example.employeemanagement.timelogs.service.TimeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/timelogs")
public class TimeLogsController {

    @Autowired
    TimeLogService timeLogService;

    @PostMapping("/add")
    public ResponseEntity<TimeLogResponse> addEntities(@RequestBody TimeLogRequest eReq) {
        return new ResponseEntity<TimeLogResponse>(timeLogService.addEntity(eReq), HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<TimeLogResponse>> findAllEntity(){
        return new ResponseEntity<List<TimeLogResponse>>(timeLogService.findAllEntity(),HttpStatus.OK);
    }
}
