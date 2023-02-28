package com.example.employeemanagement.jobs.service;

import com.example.employeemanagement.jobs.entity.Jobs;
import com.example.employeemanagement.jobs.exception.JobsNotFound;
import com.example.employeemanagement.jobs.repository.JobsRepo;
import com.example.employeemanagement.jobs.requests.JobsRequest;
import com.example.employeemanagement.jobs.response.JobsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsServiceImpl implements JobsService{

    @Autowired
    JobsRepo jobsRepo;
    @Override
    public List<JobsResponse> findAllEntity(){

        List<Jobs> list = jobsRepo.findAll();
        List<JobsResponse> jobsResponses = new ArrayList<>();
        list.forEach(e -> {
            JobsResponse eResponse = new JobsResponse(e);
            jobsResponses.add(eResponse);
        });
        return jobsResponses;
    }

    @Override
    public JobsResponse findById(Long Id){
        Jobs jobs = jobsRepo.findById(Id).orElseThrow(() -> new JobsNotFound("Job nod found with" + Id));;
        return new JobsResponse(jobs);
    }

    @Override
    public JobsResponse updateEntity(Long Id) {
        return null;
    }

    @Override
    public JobsResponse addEntity(JobsRequest jobsRequest) {
        Jobs jobs = new Jobs(jobsRequest);
        jobsRepo.save(jobs);
        return new JobsResponse(jobs);
    }

}
