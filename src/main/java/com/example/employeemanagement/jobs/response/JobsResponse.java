package com.example.employeemanagement.jobs.response;

import com.example.employeemanagement.jobs.entity.Jobs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class JobsResponse {

    private long id;

    private String jobName;

    private LocalDate startDate;

    private LocalDate endDate;

    private int estimatedHours;

    private int loggedHours;

    private int ratePerHour;

    private String billable;

    private String job_Status;

    public JobsResponse(Jobs jobs) {
        this.id = jobs.getId();
        this.jobName = jobs.getJobName();
        this.startDate = jobs.getStartDate();
        this.endDate = jobs.getEndDate();
        this.estimatedHours = jobs.getEstimatedHours();
        this.loggedHours = jobs.getLoggedHours();
        this.ratePerHour = jobs.getRatePerHour();
        this.billable = jobs.getBillable();
        this.job_Status = jobs.getJob_Status();
    }
}
