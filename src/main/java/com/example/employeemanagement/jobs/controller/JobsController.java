package com.example.employeemanagement.jobs.controller;

import com.example.employeemanagement.jobs.entity.Jobs;
import com.example.employeemanagement.jobs.requests.AddEmpJobRequest;
import com.example.employeemanagement.jobs.requests.JobsRequest;
import com.example.employeemanagement.jobs.response.JobsEmployeeResponse;
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
    @PostMapping("/add")
    public ResponseEntity<JobsResponse> addEntities(@RequestBody JobsRequest eReq) {
        return new ResponseEntity<JobsResponse>(jobsService.addEntity(eReq), HttpStatus.OK);
    }

    @PutMapping("/add/employee")
    public ResponseEntity<JobsResponse> addEmpJob(@RequestBody AddEmpJobRequest eReq){
        return new ResponseEntity<JobsResponse>(jobsService.addEmpJob(eReq),HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<JobsResponse>> findAllEntity(){
        return new ResponseEntity<List<JobsResponse>>(jobsService.findAllEntity(),HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<JobsResponse> findById(@PathVariable(name = "id")Long id){
        return new ResponseEntity<>(jobsService.findById(id),HttpStatus.OK);
    }

    //find all employees assinged to the job
    @GetMapping("/findAll/employee/{id}")
    public ResponseEntity<List<JobsEmployeeResponse>> findAllEmp(@PathVariable(name="id")Long id){
        List<JobsEmployeeResponse> jobsEmployeeResponse = jobsService.findAllEmp(id);
        return new ResponseEntity<List<JobsEmployeeResponse>>(jobsEmployeeResponse,HttpStatus.OK);
    }

    //remove employees from the job
    @PutMapping("/delete/employee")
    public ResponseEntity<JobsResponse> removeEmp(@RequestBody AddEmpJobRequest eReq){
        return new ResponseEntity<JobsResponse>(jobsService.removeEmp(eReq),HttpStatus.OK);
    }

//    @PutMapping("update/jobs")
//    public ResponseEntity<JobsResponse> updateEntity(@RequestBody JobsRequest eReq){
//        return new ResponseEntity<>(jobsService.updateEntity(eReq),HttpStatus.OK);
//    }

}
