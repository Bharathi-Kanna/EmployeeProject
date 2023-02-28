package com.example.employeemanagement.jobs.controller;

import com.example.employeemanagement.jobs.requests.JobsRequest;
import com.example.employeemanagement.jobs.response.JobsResponse;
import com.example.employeemanagement.jobs.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    JobsService jobsService;

    @PostMapping("/add/jobs")
    public ResponseEntity<JobsResponse> addEntities(@RequestBody JobsRequest eReq) {
        return new ResponseEntity<>(jobsService.addEntity(eReq), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<JobsResponse>> findAllEntity(){
        return new ResponseEntity<List<JobsResponse>>(jobsService.findAllEntity(),HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JobsResponse> findById(@PathVariable(name = "id")Long id){
        return new ResponseEntity<>(jobsService.findById(id),HttpStatus.OK);
    }

//    @PutMapping("update/jobs")
//    public ResponseEntity<JobsResponse> updateEntity(@RequestBody JobsRequest eReq){
//        return new ResponseEntity<>(jobsService.updateEntity(eReq),HttpStatus.OK);
//    }

}
