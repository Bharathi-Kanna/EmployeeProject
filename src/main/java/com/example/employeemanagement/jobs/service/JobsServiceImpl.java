package com.example.employeemanagement.jobs.service;

import com.example.employeemanagement.employee.entity.Employee;
import com.example.employeemanagement.employee.repository.EmployeeRepo;
import com.example.employeemanagement.exception.EntityNotFound;
import com.example.employeemanagement.jobs.entity.Jobs;
import com.example.employeemanagement.jobs.exception.JobsNotFound;
import com.example.employeemanagement.jobs.repository.JobsRepo;
import com.example.employeemanagement.jobs.requests.AddEmpJobRequest;
import com.example.employeemanagement.jobs.requests.JobsRequest;
import com.example.employeemanagement.jobs.response.JobsEmployeeResponse;
import com.example.employeemanagement.jobs.response.JobsResponse;
import com.example.employeemanagement.project.entity.Project;
import com.example.employeemanagement.project.exception.ProjectNotFound;
import com.example.employeemanagement.project.repository.ProjectRepo;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsServiceImpl implements JobsService{

    @Autowired
    JobsRepo jobsRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ProjectRepo projectRepo;
    @Override
    public List<JobsResponse> findAllEntity(){

        List<Jobs> list = jobsRepo.findAll();
        List<JobsResponse> jobsResponses = new ArrayList<>();
        list.forEach(e -> {
            JobsResponse eResponse = new JobsResponse(e);
            if(e.getProject_id() != null){
            Project project = projectRepo.findById(e.getProject_id()).orElseThrow(()-> new ProjectNotFound("project not found with id"));
            eResponse.setProjectName(project.getProjectName());}
            jobsResponses.add(eResponse);
        });
        return jobsResponses;
    }

    @Override
    public JobsResponse findById(Long Id){
        Jobs jobs = jobsRepo.findById(Id).orElseThrow(() -> new JobsNotFound("Job nod found with" + Id));
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

    @Override
    public JobsResponse addEmpJob(AddEmpJobRequest addEmpJobRequest) {
        Jobs jobs = jobsRepo.findById(addEmpJobRequest.getId()).orElseThrow(() -> new JobsNotFound("Job nod found "));
        List<Long> emp_id = jobs.getEmployee_id();
        List<Long> list = new ArrayList<>();
        if(emp_id != null){
        for (Long l:
             emp_id) {
            if(!addEmpJobRequest.getEmployeeId().contains(l)){
                list.add(l);
            }
        }}
        list.addAll(addEmpJobRequest.getEmployeeId());
        jobs.setEmployee_id(list);
        jobsRepo.save(jobs);
        return new JobsResponse(jobs);
    }

    //removes employee from a job
    @Override
    public JobsResponse removeEmp(AddEmpJobRequest addEmpJobRequest) {
        Jobs jobs = jobsRepo.findById(addEmpJobRequest.getId()).orElseThrow(() -> new JobsNotFound("Job nod found "));
        List<Long> emp_id = jobs.getEmployee_id();
        try{
        for(Long l: addEmpJobRequest.getEmployeeId()){
            if(emp_id.contains(l)){
                emp_id.remove(l);
            }
        }}catch (Exception e){return null;}

        jobs.setEmployee_id(emp_id);
        jobsRepo.save(jobs);
        return new JobsResponse(jobs);
    }

    //returns all the employees assinged to the job
    @Override
    public List<JobsEmployeeResponse> findAllEmp(Long id) {
        Jobs jobs = jobsRepo.findById(id).orElseThrow(() -> new JobsNotFound("Job nod found "));
        List<JobsEmployeeResponse> list = new ArrayList<>();
        try{
        List<Long> emp_id = jobs.getEmployee_id();
            for (Long l:
                 emp_id) {
                 Employee employee = employeeRepo.findById(l).orElseThrow(()-> new EntityNotFound("Employee Not found"));
                 JobsEmployeeResponse jobsEmployeeResponse = new JobsEmployeeResponse(employee);
                 list.add(jobsEmployeeResponse);
            }
        }
        catch (Exception e){
            return new ArrayList<>();
        }
        return list;
    }

}
