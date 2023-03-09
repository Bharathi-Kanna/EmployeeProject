package com.example.employeemanagement.timesheet.controller;

import com.example.employeemanagement.timelogs.request.TimeLogRequest;
import com.example.employeemanagement.timelogs.response.TimeLogResponse;
import com.example.employeemanagement.timesheet.request.TimeSheetRequest;
import com.example.employeemanagement.timesheet.response.TimeSheetResponse;
import com.example.employeemanagement.timesheet.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/timesheet")
public class TimeSheetController {

    @Autowired
    TimeSheetService timeSheetService;

    @PostMapping("/add")
    public ResponseEntity<String> addEntities(@RequestBody TimeSheetRequest eReq) {
        return new ResponseEntity<String>(timeSheetService.addEntity(eReq), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TimeSheetResponse>> findAllEntity(){
        return new ResponseEntity<List<TimeSheetResponse>>(timeSheetService.findAllEntity(),HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<String> updateEntities(@RequestBody TimeSheetRequest eReq,@PathVariable(name="id") Long id){
        return new ResponseEntity<String>(timeSheetService.updateEntity(eReq,id), HttpStatus.OK);
    }

}
