package com.example.employeemanagement.jobs.service;


import com.example.employeemanagement.jobs.requests.AddEmpJobRequest;
import com.example.employeemanagement.jobs.requests.JobsRequest;
import com.example.employeemanagement.jobs.response.JobsEmployeeResponse;
import com.example.employeemanagement.jobs.response.JobsResponse;

import java.util.List;

public interface JobsService {
    public List<JobsResponse> findAllEntity();

    public JobsResponse findById(Long Id);

    public JobsResponse updateEntity(Long Id);

    public JobsResponse addEntity(JobsRequest jobsRequest);

    public JobsResponse addEmpJob(AddEmpJobRequest addEmpJobRequest);

    public List<JobsEmployeeResponse> findAllEmp(Long id);

    JobsResponse removeEmp(AddEmpJobRequest eReq);
}