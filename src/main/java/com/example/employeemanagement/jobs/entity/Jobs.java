package com.example.employeemanagement.jobs.entity;

import com.example.employeemanagement.jobs.requests.JobsRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jobs")
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private long id;

    @Column(name = "job_name")
    private String jobName;

    @Column(name="start_date")
    private String startDate;

    @Column(name="end_date")
    private String endDate;

    @Column(name="estimated_hours")
    private int estimatedHours;

    @Column(name="logged_hours")
    private int loggedHours;

    @Column(name="rate_per_hour")
    private int ratePerHour;

    @Column(name="billable")
    private String billable;

    @Column(name="job_status")
    private String job_Status;

    private Long project_id;

    public Jobs(JobsRequest jobsRequest){
        this.jobName = jobsRequest.getJobName();
        this.startDate = jobsRequest.getStartDate();
        this.endDate = jobsRequest.getEndDate();
        this.estimatedHours = jobsRequest.getEstimatedHours();
        this.loggedHours = jobsRequest.getEstimatedHours();
        this.ratePerHour = jobsRequest.getRatePerHour();
        this.billable = jobsRequest.getBillable();
        this.job_Status = jobsRequest.getJob_Status();
    }

}
